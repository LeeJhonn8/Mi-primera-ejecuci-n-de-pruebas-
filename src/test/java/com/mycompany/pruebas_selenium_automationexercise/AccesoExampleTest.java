
package com.mycompany.pruebas_selenium_automationexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesoExampleTest {

    @Test
    public void verificarPaginaPrincipal() {

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://automationexercise.com.");

            String titulo = driver.getTitle();

            assertEquals("Automation Exercise", titulo);

            System.out.println("PRUEBA EXITOSA: " + titulo);

        } finally {
            driver.quit();
        }
    }
}
