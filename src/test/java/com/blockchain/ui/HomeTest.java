package com.blockchain.ui;

import com.blockchain.data.PagesLinks;
import com.blockchain.data.PagesNames;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomeTest extends com.blockchain.ui.BaseTest {

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = false;
    public static final boolean testCase5 = false;
    public static final boolean testCase6 = true;

    @Test //(priority = 1, enabled = testCase1, groups = {"chrome"})
    public void isHomePage(){
        homePage.openPage(PagesLinks.homeUrl);
        Assert.assertTrue(homePage.isHome());
    }
    
}
