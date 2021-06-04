package com.WebstaurantStore.data;
import java.util.HashMap;

final public class PagesLinks {
    public static HashMap<Enum,String>  navMenuLinks = new HashMap<>();
// NAV MENU links__________________________
    public static HashMap<Enum,String> getNavMenuLinks() {
        navMenuLinks.put(PagesNames.TABLETOP,"https://www.webstaurantstore.com/restaurant-tabletop-supplies.html");
        //TODO add another menu links


        return navMenuLinks;
    }
    //HOME
    public static String homeUrl = "https://www.webstaurantstore.com";

}
