package com.WebstaurantStore.ui;


import com.WebstaurantStore.data.Helpers;
import com.WebstaurantStore.data.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Scanner;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver, explicitWait);
    }

    List<WebElement> newSearch;
    String initialSearchUrl = "";
    String lastItemId = "";

    public int numberOfPagesInSearchresult(){
        List<WebElement> lowerBarPageNumbers = Helpers.getWebElementList(Locators.lowerPageNumberBar); //getting pages numbers
        try {
            Scanner pages = new Scanner(lowerBarPageNumbers.get(lowerBarPageNumbers.size() - 1).getText()); // getting int from text button
            return pages.nextInt();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException, wrong data in low page bar");
            return 1;
        }
    }

    public void setInitialSearchUrl(String searchData){
        serachHomePageResultItems(searchData);
        initialSearchUrl=driver.getCurrentUrl();
    }

    public String getInitialSearchUrl(){
        return initialSearchUrl;
    }

    public void pageSelectorUrl(int pageNum, String searchData){
        String pageUrl = getInitialSearchUrl()+"?page="+pageNum;
        try {
            openPage(pageUrl);
        } catch (NullPointerException e){
            System.out.println("wrong page number - " + e);
        }
    }


    public void serachHomePageResultItems(String searchData){
        Helpers.getWebElement(Locators.searchInputMainPage).sendKeys(searchData); // Search preset data
        Helpers.getWebElement(Locators.searchButtonMainPage).click();  // click on Search button
    }

    public List<WebElement> serachHomePageResultItemsCollector(){
        newSearch = Helpers.getWebElementList(Locators.searchResultsItems); // getting searched items from 1st page
        return newSearch;
    }



    public boolean checkSerachResultsForMatch(String validData, String searchData) {
        int validCount=0;
        int numberOfPagesInSearchresult=numberOfPagesInSearchresult();
                for (int i = 1; i <= numberOfPagesInSearchresult; i++) {  // collecting data from all pages
                    pageSelectorUrl(i, searchData);
                    for (int j = 0; j < serachHomePageResultItemsCollector().size(); j++) { // collecting data from current pages
                        if (serachHomePageResultItemsCollector().get(j).getText().trim().toLowerCase().contains(validData.toLowerCase())) {
                            validCount++;
                           // System.out.println(validData+ "  found in " + "element #"+i+" "+ j+ " - " + serachHomePageResultItemsCollector().get(j).getText());
                        } else {
                            System.out.println("element #"+i+" "+ j+ " Has no "+ validData+ "  in " + serachHomePageResultItemsCollector().get(j).getText());
                        }
                    }
                }
                System.out.println("Total matches  -   "+ validCount++);
       return validCount==newSearch.size();
    }

    public void setLastItemId(String searchData){
        pageSelectorUrl(numberOfPagesInSearchresult(), searchData);
        List<WebElement> newSearchIDs = Helpers.getWebElementList(Locators.ItemId);
        String itemId = newSearchIDs.get(newSearchIDs.size()-1).getText();
        System.out.println(itemId.replace("#","").trim() + "<-------------- Item Id for last item");
        lastItemId = itemId.replace("#","").trim();
    }

    public String getLastItemId(){
        return lastItemId;
    }

    public WebElement getLastItemButton() {
        //pageSelectorUrl(numberOfPagesInSearchresult(), searchData);
        //explicitWait.until(ExpectedConditions.visibilityOf(Helpers.getWebElement(Locators.itemButtonAddToCart)));
        Helpers.ajaxScrollDown(Helpers.getWebElement(Locators.lowerPageNumberBar));
        List<WebElement> newSearchButtons = Helpers.getWebElementList(Locators.itemButtonAddToCart);
        WebElement item = newSearchButtons.get(newSearchButtons.size()-1);
        return item;
    }

    public void addingToCart(String searchData) {
        pageSelectorUrl(numberOfPagesInSearchresult(), searchData);
        WebElement button = getLastItemButton();
        Helpers.ajaxScrollDown(button);
        button.click();
        explicitWait.until(ExpectedConditions.visibilityOf(Helpers.getWebElement(Locators.closeButtonOnCartNotifierMsg)));
        Helpers.getWebElement(Locators.closeButtonOnCartNotifierMsg).click();
    }


    public boolean isDeleted() {
        return isDeleted("");
    }

    public boolean isDeleted(String itemIdForCheck) {
        boolean flag=false;
        try {
            List<WebElement> cartItems = Helpers.getWebElementList(Locators.itemInCartEntire);

            if (cartItems.size()>1) {
                for (int i = 0; i < cartItems.size(); i++) {
                    if (cartItems.get(i).getText().contains(itemIdForCheck)) {
                        System.out.println(itemIdForCheck + " still in cart");
                        flag = false;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e + "  no this item found for after delete - " + itemIdForCheck);
            flag = true;
        }
        explicitWait.until(ExpectedConditions.visibilityOf(Helpers.getWebElement(Locators.cartEmptyHeader)));
        if (Helpers.getWebElement(Locators.cartEmptyHeader).getText().contains("Your cart is empty")){
            System.out.println("Your cart is empty");
            flag = true;
        }
        System.out.println("delete status - " + flag);
        return flag;
    }

    public boolean cartItemCheckerAndDeleteSingleItem(String itemIdForCheck) {     // deleting single item
        WebElement item = null;
        Helpers.getWebElement(Locators.cartHome).click();
        boolean flag= false;

        try {
            List<WebElement> cartItems = Helpers.getWebElementList(Locators.itemInCart);
            for (int i = 0; i < cartItems.size(); i++) {
                //System.out.println(cartItems.get(i).getText());
                if (cartItems.get(i).getText().contains(itemIdForCheck)){
                    cartItems.get(i).findElement(By.xpath(Locators.deleteButton)).click();
                    flag=true;
                    System.out.println("id matches in cart "+ itemIdForCheck+ ".  deleting...");
                }
            }

        } catch (NoSuchElementException e) {
            System.out.println(e + "  no Element found for " + itemIdForCheck);
            flag =  false;
        }
        System.out.println(flag);
        return flag;
    }

    public void emptyCart(){
        Helpers.getWebElement(Locators.cartHome).click();
        Helpers.getWebElement(Locators.emptyCartButton).click();
        explicitWait.until(ExpectedConditions.visibilityOf(Helpers.getWebElement(Locators.emptyCartConfirmButton)));
        Helpers.getWebElement(Locators.emptyCartConfirmButton).click();
    }
}
