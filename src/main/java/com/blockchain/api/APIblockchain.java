package com.blockchain.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import models.Ticker;
import models.Tickers;


import static io.restassured.RestAssured.given;

public class APIblockchain {
    //Get specific ticker info
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

        // Some additional data for test dev purpose
        response.getBody().prettyPrint();
        System.out.println(response.getTime()+ "milli seconds");
        System.out.println("server response - "+response.getStatusCode());
        System.out.println("Date -  "+response.getHeader("Date"));
        JsonPath jsonPath = response.jsonPath();
        return response;
    }
    //Get all tickers info
    public static Response getTickerInfo(){
        return getTickerInfo("");

    }
    public static String getCurrencyElementAPI(JsonPath jsonPath){ //return ticker name from API exchange/tickers/
        return  jsonPath.getString("symbol");
    }
    public static String getTickerParameterValueAPI(String symbol, String element){  // return specific element from API exchange/tickers/
        return  getJsonFromResponce(getTickerInfo(symbol)).getString(element);
    }
    public static JsonPath getJsonFromResponce(Response response){ // return jsonPath
        JsonPath jsonPath = response.jsonPath();;
        return  jsonPath;
    }
    public static int getServerCodeResponce(Response response){ // return server code
        return  response.getStatusCode();
    }

    public static Ticker[] getFullAPIJSONresponce(JsonPath jsonPath){ // return model array of full model exchange/tickers/
        return jsonPath.getObject("$",Ticker[].class);
    }


}
