package com.WebstaurantStore.ui;

import com.WebstaurantStore.data.Data;
import com.WebstaurantStore.data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomeTest extends com.WebstaurantStore.ui.BaseTest {

    @DataProvider(name = "ValidationData")
    public static Object[][] homePageSearchValidationData(){
        return new Object[][]{
                // Validation data for matching,  Search request
                {Data.validationDataHomeTest_TABLE, Data.searchDataHomeTest},
                {Data.validationDataHomeTest_TABLES, Data.searchDataHomeTest}

        };
    }

    public static final boolean testCase1 = true;


    @Test (dataProvider = "ValidationData",priority = 1, enabled = testCase1, groups = {"Chrome"})
    public void searchTestResults_1(String validationData, String searchData) {
        homePage.openPage(PagesLinks.homeUrl);
        homePage.setInitialSearchUrl(searchData);

        softAssert.assertTrue(homePage.checkSerachResultsForMatch(validationData, searchData));

        homePage.setLastItemId(searchData);
        homePage.addingToCart(searchData);
        homePage.emptyCart();
        //softAssert.assertTrue(homePage.cartItemCheckerAndDeleteSingleItem(homePage.getLastItemId()));

        Assert.assertTrue(homePage.isDeleted(homePage.getLastItemId()));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
