package com.WebstaurantStore.ui;

import com.WebstaurantStore.data.Data;
import com.WebstaurantStore.data.PagesLinks;
import com.WebstaurantStore.data.PagesNames;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomeTest extends com.WebstaurantStore.ui.BaseTest {

    @DataProvider(name = "ValidationData")
    public static Object[][] homePageSearchValidationData(){
        return new Object[][]{
                {Data.validationDataHomeTest_TABLE},
                {Data.validationDataHomeTest_TABLES},
                {"tableware"},
        };
    }

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = false;
    public static final boolean testCase4 = false;
    public static final boolean testCase5 = false;
    public static final boolean testCase6 = false;

    @Test (dataProvider = "ValidationData",priority = 1, enabled = testCase1, groups = {"Chrome"})
    public void searchTestResults_1(String validationData){
        homePage.openPage(PagesLinks.homeUrl);
        Assert.assertTrue(homePage.serachTestResults(validationData));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Thread.sleep(1000);
        driver.quit();
    }
}
