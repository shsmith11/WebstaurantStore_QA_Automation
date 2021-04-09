package com.blockchain.data;
import java.util.HashMap;

final public class PagesLinks {
    public static HashMap<Enum,String>  navMenuLinks = new HashMap<>();
// NAV MENU links__________________________
    public static HashMap<Enum,String> getNavMenuLinks() {
        navMenuLinks.put(PagesNames.HOME,"https://www.blockchain.com");
        navMenuLinks.put(PagesNames.WALLET,"https://www.blockchain.com/wallet");
        navMenuLinks.put(PagesNames.EXCHANGE,"https://exchange.blockchain.com");
        navMenuLinks.put(PagesNames.EXPLORER,"https://www.blockchain.com/explorer");


        return navMenuLinks;
    }

    public static String homeUrl = "https://www.blockchain.com";



}
