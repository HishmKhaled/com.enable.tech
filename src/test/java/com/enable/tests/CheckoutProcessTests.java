package com.enable.tests;

import com.enable.pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutProcessTests extends BaseTest {

    InventoryPage inventoryPage = new InventoryPage(getDriver());
    CartPage cartPage = new CartPage(getDriver());
    CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
    CheckOutTwoPage checkOutTwoPage = new CheckOutTwoPage(getDriver());

    //method
    private void login(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();
        //assertEquals(inventoryPage.getHomeTitle(),"Swag Labs");
    }

    @Test(description = "Verify that the user is on the cart page after adding an item to the cart" )
    public void addItemToCart(){

        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        assertEquals(cartPage.getYOurCartTitle(),"Your Cart");
    }


    @Test(description = "Verify that the user can proceed to checkout from the cart page")
    public void proceedToCheckout(){

        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        assertEquals(checkOutStepOnePage.getYourPagetTitle(),"Checkout: Your Information");
    }


    @Test(description = "Verify that the user can fill out the checkout information form")
    public void fillCheckoutForm(){


        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        assertEquals(checkOutTwoPage.getYourPagetTitle(),"Checkout: Overview");
    }


    @Test(description = "Verify that the user can’t proceed to checkout Overview without filling out the form")
    public void errorMessageDisplayedWhenFormhasEmptyFields(){
        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage.clickOnContinueButton();

        assertEquals(checkOutStepOnePage.getTheErrorMessage(),"Error: First Name is required");
    }

    @Test(description = "Verify that the user can verify the order details on the checkout overview page")
    public void orderDetails(){
        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        assertEquals(checkOutTwoPage.getInventoryItemName(),"Sauce Labs Bike Light");
    }

    @Test(description = "Verify that the user can complete the order on the checkout overview page")
    public void completeTheOrder(){

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(getDriver());

        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        checkOutTwoPage.clickOnFinishButton();

        assertEquals(checkoutCompletePage.getConforamtionMessage(),"Thank you for your order!");
    }



}
