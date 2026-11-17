package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaProductos {

    @Test
    public void verificarSeccionProductos() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com/products");

            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
            );

            wait.until(d -> !d.findElements(
                By.cssSelector(".features_items .product-image-wrapper")
            ).isEmpty());

            int cantidadProductos = driver.findElements(
                By.cssSelector(".features_items .product-image-wrapper")
            ).size();

            assertTrue(cantidadProductos > 0,
                "No se encontraron productos");

            System.out.println(
                "PRUEBA EXITOSA: Productos encontrados: " + cantidadProductos
            );

        } finally {
            driver.quit();
        }
    }
}