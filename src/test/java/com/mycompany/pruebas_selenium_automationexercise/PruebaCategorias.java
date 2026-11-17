package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaCategorias {

    @Test
    public void verificarCategorias() {

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

            boolean categoriasVisibles = wait.until(d ->
                d.findElement(By.id("accordian")).isDisplayed()
            );

            assertTrue(categoriasVisibles,
                "Las categorías deberían estar visibles");

            System.out.println(
                "PRUEBA EXITOSA: Categorías visibles"
            );

        } finally {
            driver.quit();
        }
    }
}