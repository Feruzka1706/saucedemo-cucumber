package com.saucedemo.pages;

import com.saucedemo.utility.Driver;

public class ProductPage {

    public boolean isAt() {

        // check the url is https://www.saucedemo.com/inventory.html
        return Driver.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/inventory.html") ;

    }


}
