package com.blockchain.data;

import java.util.HashMap;

final public class Data {

    public static String[] months = {"Jan","Feb","Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec"};

    // login Data

    public static String emailLogin="sh11usertest";
    public static String passLogin="test11!";



    // Registration Data
    public static String phoneReg ="3056667788";
    public static String locationReg ="tampa";
    public static String emailReg = Helpers.randomEmailString();
    public static String passReg = Helpers.randomPassword();
    public static String userReg = Helpers.randomUserString();
    public static String dayReg = Helpers.toString(Helpers.randomInt(1,30));
    public static String monthReg = Data.months[Helpers.randomArrArg(Data.months)];
    public static String yearReg = Helpers.toString(Helpers.randomInt(1940,Helpers.getCurrentYear()-18));

    //Search Data

    public static int imageOnPage = 12;
    public static int trys = 10;
    public static int tryMS = 100;


    //Expected Nav Menu Data
    public static HashMap<Enum,String> expectedH1 = new HashMap<>();
    public static HashMap<Enum,String> expectedTitles = new HashMap<>();

}
