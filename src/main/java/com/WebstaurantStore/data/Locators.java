package com.WebstaurantStore.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

final public class Locators {
    // MAIN PAGE LOCATORS

    public static String searchInputMainPage = "//input[@id='searchval']";
    public static String searchButtonMainPage = "//button[@value='Search']";


    //SERCH PAGE
    public static String searchResultsItems = "//div[@class='ag-item gtm-product']"; //"//a[@data-testid='itemDescription']";  //"//div[@class='ag-item gtm-product']";
    public static String itemButtonAddToCart = "//input[@data-testid='itemAddCart']";
    public static String lowerPageNumberBar = "//li[contains(@class, 'rc-pagination-item rc-pagination-item')]";
    public static String lowerPageBarNext = "//a[contains(@class, 'rounded-r-md')]";
    public static String lowerPageBarFirstPagebutton = "//li[contains(@class,'rc-pagination-item rc-pagination-item-1')]";  //"//div[@id='paging']//a[contains(text(),'1')]";
    public static String closeButtonOnCartNotifierMsg = "//button[@class='close']";
    public static String cartHome = "//a[@data-testid='cart-nav-link']";
    public static String ItemId = "//span[@class ='bg-white py-0 px-1 absolute whitespace-no-wrap']";

    //CART
    public static String itemIdInCart = "//p[@class ='itemNumber sub-text']";
    public static String itemInCartByID = "//div[@data-itemnumber='";
    public static String deleteButton = "//a[@class ='deleteCartItemButton itemDelete__link itemDelete--positioning']";
    public static String itemInCart = "//div[contains (@class,'cartItemWrapper cartItemId_id')]";
    public static String itemInCartEntire = "//div[@class ='cartItem ag-item gtm-product-auto']";
    public static String cartEmptyHeader = "//p[@class='header-1']";
    public static String emptyCartButton = "//a[@class='emptyCartButton btn btn-mini btn-ui pull-right']";
    public static String emptyCartConfirmButton = "//button[@class='btn btn-primary']";

}
