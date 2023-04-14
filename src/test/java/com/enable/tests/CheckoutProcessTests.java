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
        assertEquals(inventoryPage.getHomeTitle(),"Swag Labs");
    }

    //Verify that the user is on the cart page after adding an item to the cart
    @Test
    public void verify_That_User_Can_Add_Item_To_Cart(){

        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        assertEquals(cartPage.getYOurCartTitle(),"Your Cart");
    }

    //Verify that the user can proceed to checkout from the cart page
    @Test
    public void verify_That_User_Can_proceed_To_Checkout(){

        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        assertEquals(checkOutStepOnePage.getYourPagetTitle(),"Checkout: Your Information");
    }

    //Verify that the user can fill out the checkout information form
    @Test

    public void verify_That_User_Can_Fill_Checkout_Form(){


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

    //Verify that the user can’t proceed to checkout Overview without filling out the form
    @Test
    public void verify_That_User_See_The_error_Message_When_He_Didnt_Fill_The_Form(){
        login("standard_user","secret_sauce");

        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage.clickOnContinueButton();

        assertEquals(checkOutStepOnePage.getTheErrorMessage(),"Error: ");

    }

    //Verify that the user can verify the order details on the checkout overview page
    @Test
    public void verify_The_Order_Details_On_The_Checkout_OVerView(){
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

    //Verify that the user can complete the order on the checkout overview page
    @Test
    public void verify_That_user_can_complete_The_Order_On_Checkout_page(){

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
