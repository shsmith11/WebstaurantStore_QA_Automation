package com.blockchain.ui;


import com.blockchain.data.Helpers;
import com.blockchain.data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class HomePage extends BasePage{



    public HomePage(WebDriver driver) {
        super(driver, explicitWait);
    }

    public boolean isHome(){
        String expectedHomeTitle =  "Blockchain.com - The Most Trusted Crypto Company";
        try{
            explicitWait.until(ExpectedConditions.titleContains(expectedHomeTitle));
            return true;
        } catch (TimeoutException err) {
            return false;
        }
    }

}
