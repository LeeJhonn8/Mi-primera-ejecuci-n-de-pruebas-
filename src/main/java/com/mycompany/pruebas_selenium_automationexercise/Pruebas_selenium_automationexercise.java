package com.mycompany.pruebas_selenium_automationexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pruebas_selenium_automationexercise {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // Ubicacion del navegador Brave
        options.setBinary(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.example.com");

            System.out.println("Titulo de la pagina: "
                    + driver.getTitle());

            System.out.println("URL actual: "
                    + driver.getCurrentUrl());

        } finally {
            driver.quit();
        }
    }
}
