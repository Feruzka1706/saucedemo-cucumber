package com.saucedemo.pages;

import com.saucedemo.utility.ConfigReader;
import com.saucedemo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="user-name")
    private WebElement usernameElm ;
    @FindBy(id="password")
    private WebElement passwordElm ;
    @FindBy(id="login-button")
    private WebElement loginBtn ;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void goTo() {

        Driver.getDriver().get(ConfigReader.read("sauce_url"));

    }


    public void loginAs(String userType) {

//         String userName = ConfigReader.read("standard_user");
        String userName = ConfigReader.read(userType+ "_user");
        String password = ConfigReader.read("password");

        this.usernameElm.sendKeys(userName) ;
        this.passwordElm.sendKeys(password) ;
        this.loginBtn.submit();

    }
}
