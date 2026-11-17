package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaBusquedaProductos {

    @Test
    public void buscarProducto() {

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

            wait.until(d -> d.findElement(
                By.id("search_product")
            ).isDisplayed());

            driver.findElement(By.id("search_product")).sendKeys("top");

            driver.findElement(By.id("submit_search")).click();

            boolean resultados = wait.until(d ->
                !d.findElements(
                    By.cssSelector(".features_items .product-image-wrapper")
                ).isEmpty()
            );

            assertTrue(resultados,
                "Deberían aparecer productos relacionados con la búsqueda");

            System.out.println(
                "PRUEBA EXITOSA: Búsqueda de productos realizada"
            );

        } finally {
            driver.quit();
        }
    }
}