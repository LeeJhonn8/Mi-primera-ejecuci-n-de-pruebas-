package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaCarrito {

    @Test
    public void agregarProductoAlCarrito() {

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com/product_details/1");

            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
            );

            wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cart")
            )).click();

            boolean mensajeVisible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("cartModal")
                )
            ).getText().contains("Your product has been added to cart.");

            assertTrue(
                mensajeVisible,
                "El producto debería agregarse al carrito"
            );

            System.out.println(
                "PRUEBA EXITOSA: Producto agregado al carrito"
            );

        } finally {
            driver.quit();
        }
    }
}