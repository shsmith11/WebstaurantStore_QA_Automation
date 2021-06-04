package com.WebstaurantStore.ui;


import com.WebstaurantStore.data.Data;
import com.WebstaurantStore.data.Helpers;
import com.WebstaurantStore.data.Locators;
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

    public boolean serachTestResults(String validData) {

        Helpers.getWebElement(Locators.searchInputMainPage).sendKeys(Data.searchDataHomeTest);
        Helpers.getWebElement(Locators.searchButtonMainPage).click();
        List<WebElement> newSearch = Helpers.getWebElementList(Locators.searchResults);
        int validCount=0;
            try {
                for (int i = 0; i < newSearch.size(); i++) {
                    if (newSearch.get(i).getText().trim().toLowerCase().contains(validData.toLowerCase())) {
                        validCount++;
                        System.out.println(validData+ "  found in " + "element #"+ i+ " - " + newSearch.get(i).getText());
                    } else {
                        System.out.println("element #"+ i+ " Has no "+ validData+ "  in " + newSearch.get(i).getText());

                    }
                }
            } catch (NullPointerException e) {

                System.out.println(e + "  No Elements Found");
            }
        System.out.println("Total matches  -   "+ validCount++);
       return validCount==newSearch.size();
    }

}
