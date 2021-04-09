package com.blockchain.ui;

import com.blockchain.data.Locators;
import com.blockchain.api.APIblockchain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorerPage extends BasePage{

    public ExplorerPage(WebDriver driver) {

        super(driver, explicitWait);
    }

    public WebElement explorerBTCPrice(){return driver.findElement(By.xpath(Locators.explorerBTCPrice));}





    public boolean isCorrect(String tickerName, Enum tickerParam){
        boolean isCorrect;
        String tickerValue = APIblockchain.getTickerParameterValueAPI(tickerName, tickerParam.toString().toLowerCase().trim());
        String tickerOnPage = explorerBTCPrice().getText().replace("$","").replace(",","");
        if (tickerOnPage.contains(tickerValue)){
            isCorrect = true;
        } else isCorrect = false;
        System.out.println("Value on Page = " + tickerOnPage+ ",  Value API = "+ tickerValue);
        return isCorrect;
    }
}
