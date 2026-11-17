package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaDetalleProducto {

    @Test
    public void verificarDetalleProducto() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(
                "https://automationexercise.com/product_details/1"
            );

            WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
            );

            WebElement detalle = wait.until(d ->
                d.findElement(
                    By.cssSelector(".product-information h2")
                )
            );

            assertTrue(detalle.isDisplayed(),
                "El detalle del producto debería estar visible");

            System.out.println(
                "PRUEBA EXITOSA: " + detalle.getText()
            );

        } finally {
            driver.quit();
        }
    }
}