package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SauceDemoLoginSteps {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Given("I am at sauce demo login page")
    public void i_am_at_sauce_demo_login_page() {

        System.out.println("Given I am at sauce demo login page");

        loginPage.goTo();

    }

    @When("I provide credentials for {string} user")
    public void i_provide_credentials_for_user(String userType) {

        System.out.println("When I provide credentials for "+ userType+ " user");

         loginPage.loginAs(userType) ;

    }

    @Then("I should see product page")
    public void i_should_see_product_page() {

        System.out.println("Then I should see product page");

          Assert.assertTrue(  productPage.isAt() ) ;

    }


}
