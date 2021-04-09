package com.blockchain.data;
import com.blockchain.ui.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Helpers extends BasePage {

    public Helpers(WebDriver driver, WebDriverWait explicitWait) {
        super(driver, explicitWait);
    }

    static public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        explicitWait.until(pageLoadCondition);
    }

    static public int randomInt(int begin, int end){
        Random rand = new Random();
        return rand.nextInt(end-begin)+begin;
    }
    static public int randomArrArg(String[] arr){  //random int of array length
        Random rand = new Random();
        return rand.nextInt(arr.length-1);
    }

    public static String randomUserString(){
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        return "SH11"+ RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String randomPassword(){
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public static String randomText(int length){
        //int length = 20;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String randomEmailString(){
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = false;
        return "sh11"+ RandomStringUtils.random(length, useLetters, useNumbers)+"@test.com";
    }

    public static String dropDownSetMinValue(String locator){
        String minValue = driver.findElements(By.xpath(locator)).get(0).getText();
        return minValue;
    }

    public static String dropDownSetMaxValue(String locator){
        List<WebElement> elementsList=driver.findElements(By.xpath(locator));
        String maxValue = elementsList.get(elementsList.size()-1).getText();
        return maxValue;
    }

    public static void inputEmail(String email,WebElement inputEmail){
        inputEmail.sendKeys(email);
    }
    public static void inputPass(String pass,WebElement inputPass){
        inputPass.sendKeys(pass);
    }
    public static void inputUser(String user, WebElement inputUser){
        inputUser.sendKeys(user);
    }
    public static void inputTextData(int length, WebElement inputText){
        inputText.sendKeys(randomText(length));
    }
    public static String toString(int arg) {
        return Integer.toString(arg);
    }
    public static int getCurrentDay(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.DAY_OF_MONTH); // 17
    }
    public static int getCurrentMonth(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.MONTH); // 17
    }
    public static int getCurrentYear(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.YEAR); // 17
    }
    //when regular send keys is not working and locator is correct
    public static void ajaxSenKeys(WebDriver driver, WebElement element, String text){
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }
    public static void getDropDownListByIndex(WebElement locator, int index) {
        Select select = new Select(locator);
        select.selectByIndex(index);
    }

    public static void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void setDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public static void setDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static String getDropDownListByRandomValue(WebElement element, String ValueAttributeName) {
        Select select = new Select(element);
        int selectOption = Helpers.randomInt(0, select.getOptions().size());
        return select.getOptions().get(selectOption).getAttribute(ValueAttributeName);
    }

    public static HashMap<String,String> getDropDownMapRangeByRandomValue(WebElement minElement, WebElement maxElement, String ValueAttributeName) {
        Select selectMin = new Select(minElement);
        Select selectMax = new Select(maxElement);
        int selectOptionMin = Helpers.randomInt(0, selectMin.getOptions().size());
        int selectOptionMax = Helpers.randomInt(selectOptionMin, selectMax.getOptions().size());
        HashMap<String,String> minMaxValues = new HashMap<>();
        minMaxValues.put("min", selectMin.getOptions().get(selectOptionMin).getAttribute(ValueAttributeName));
        minMaxValues.put("max", selectMax.getOptions().get(selectOptionMax).getAttribute(ValueAttributeName));
        return minMaxValues;
    }

    //overload
    public static void ajaxClick(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public static void ajaxScrollDown(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    //especially good for IE (ajax doesn't work well with IE)
    public static void performClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();

    }

    public static void perfomClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public static void clickUnselectedCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            ajaxClick(checkbox);
        }
    }

    public static void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo (0,document.body.scrollHeight);");
    }

    public static void ajaxScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //explicit & implicit waits
    public static void javaWait(int ms) {
        System.out.println("Parent!!!");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void javaWaitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Method for random choice from drop down list
    public static void selectItemDropDownRandomOption(WebElement element, String dropDownName) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(element);
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + ": " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
        }
    }

    //attribute can be source, style, href, etc. -  anything we have inside the element
    public static void checkLinksOnWebPage(String typeElement, String attribute) {

        List<WebElement> links = driver.findElements(By.xpath(typeElement));

        System.out.println("I start taking attributes on page");
        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            String url = ele.getAttribute(attribute);
            verifyLinkActive(url);
        }
        System.out.println("Total links are " + links.size());
    }

    //Method for link verification
    public static void verifyLinkActive(String linkURL) {
        try {
            URL url = new URL(linkURL);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkURL + " - " + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(linkURL + " - " + httpURLConnect.getResponseMessage() + " - " + httpURLConnect.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSizeDropDownList(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size();

        } catch (NoSuchElementException e) {
            System.out.println("getSizeDropDownList error");
        }
        return 0;
    }

    public static void clickValueOfList(By locator, String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText();
            if (value.contains(text)) {
                elementOfList.click();

            }
        }
    }

    public static String getH1Title() {
        String title = driver.findElement(Locators.H1_TITLE).getText();
        return title;
    }

    public static String getElementAttributeValue(WebElement element, String Attribute){
        return element.getAttribute(Attribute);
    }

}
