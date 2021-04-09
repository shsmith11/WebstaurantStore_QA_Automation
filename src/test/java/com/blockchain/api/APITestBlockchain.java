package com.blockchain.api;

import io.restassured.path.json.JsonPath;
import models.Tickers;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class APITestBlockchain {
    @Parameters({"symbol"})
    @Test(groups = {"API"})
    public void testAPIGetData(){
        var responceData = APIblockchain.getTickerInfo("BTC-USD");
        Assert.assertEquals(200,APIblockchain.getServerCodeResponce(responceData));
    }

    @Test(groups = {"API"})   // This test just for testing API data for development purpose
    public void testAPIGetCountryData(@Optional("") String symbol){
        //DataAPI dataAPI = new DataAPI();
        var responceData = APIblockchain.getTickerInfo(symbol);
        JsonPath jsonPath = APIblockchain.getJsonFromResponce(responceData);
        var ticker = APIblockchain.getFullAPIJSONresponce(jsonPath);
        System.out.println("Here is API com.blockchain.data Array: " + ticker[25].price_24h);
        System.out.println("Here is API com.blockchain.data Array: " + ticker.length);
        System.out.println("Here is API com.blockchain.data: " + jsonPath.getString("symbol"));
        System.out.println("Here is API com.blockchain.data: " + jsonPath.getString("volume_24h"));
        System.out.println("Here is API com.blockchain.data: " + APIblockchain.getFullAPIJSONresponce(jsonPath));
        Assert.assertTrue(APIblockchain.getCurrencyElementAPI(jsonPath)!=null);
    }
}
