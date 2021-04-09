package com.blockchain.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import models.Ticker;
import models.Tickers;


import static io.restassured.RestAssured.given;

public class APIblockchain {

    public static Response getTickerInfo(String symbol){ /* symbol name  example BTC-EUR   */
        Response response =
            given()
                .baseUri("https://api.blockchain.com")
                .basePath("/v3/exchange/tickers/"+symbol)
                .contentType(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(200)
                .extract()
                .response();

        response.getBody().prettyPrint();
        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        System.out.println("Date -  "+response.getHeader("Date"));
        JsonPath jsonPath = response.jsonPath();
        return response;
    }

    public static Response getTickerInfo(){
        return getTickerInfo("");

    }
    public static String getCurrencyElementAPI(JsonPath jsonPath){
        String currency;
        return  currency = jsonPath.getString("response.symbol");
    }
    public static String getElementAPI(JsonPath jsonPath, String element){
        return  jsonPath.getString("response."+element);
    }
    public static JsonPath getJsonFromResponce(Response response){
        JsonPath jsonPath = response.jsonPath();;
        return  jsonPath;
    }
    public static int getServerCodeResponce(Response response){
        return  response.getStatusCode();
    }

    public static Ticker[] getFullAPIJSONresponce(JsonPath jsonPath){
        return jsonPath.getObject("$",Ticker[].class);
    }


}
