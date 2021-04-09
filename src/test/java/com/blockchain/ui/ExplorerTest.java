package com.blockchain.ui;

import com.blockchain.data.PagesLinks;
import com.blockchain.data.TickerParameters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplorerTest extends com.blockchain.ui.BaseTest{

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;

    @Test (priority = 1, enabled = testCase1, groups = {"chrome"})
    public void BTCPriceCheck(){   //checking correct BTC price
        explorerPage.openPage(PagesLinks.explorerUrl);
        Assert.assertTrue(explorerPage.isCorrect("BTC-USD",TickerParameters.LAST_TRADE_PRICE)); // hardcoded format BTC-USD TODO ENUM for tickers
    }
}
