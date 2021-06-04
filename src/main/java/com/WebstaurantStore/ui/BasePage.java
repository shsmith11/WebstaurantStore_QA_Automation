package com.WebstaurantStore.ui;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected FluentWait<WebDriver> fluentWait;
    protected static WebDriverWait explicitWait;
    protected Actions action;

    public void openPage(String url){
        driver.get(url);
    }

    public BasePage(WebDriver driver, WebDriverWait explicitWait) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, 10);
        this.fluentWait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(80))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        action = new Actions(this.driver);
        }

        // override example

    public void textFromFile() throws IOException {
        Files.readAllLines(Paths.get("HWs.txt")).stream().forEach(s-> {
            String text = s.toUpperCase();
            System.out.println("Parent method TEXT - "+ text);
        });
    }
}
