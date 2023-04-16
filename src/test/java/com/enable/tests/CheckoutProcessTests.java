package com.enable.tests;

import com.enable.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutProcessTests extends BaseTest {

    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutStepOnePage checkOutStepOnePage;
    CheckOutTwoPage checkOutTwoPage;
    CheckoutCompletePage checkoutCompletePage;


    //method
    protected synchronized void loginMethod(WebDriver driver){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(valid_UserName);
        loginPage.enterPassword(valid_Password);
        loginPage.clickOnLogin();
    }

    @Test(description = "Verify that the user is on the cart page after adding an item to the cart" )
    public synchronized void addItemToCart(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        assertEquals(cartPage.getYOurCartTitle(),"Your Cart");
    }

    @Test(description = "Verify that the user can’t proceed to checkout Overview without filling out the form")
    public synchronized void errorMessageDisplayedWhenFormhasEmptyFields(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
        checkOutStepOnePage.clickOnContinueButton();

        assertEquals(checkOutStepOnePage.getTheErrorMessage(),"Error: First Name is required");
    }

    @Test(description = "Verify that the user can verify the order details on the checkout overview page")
    public synchronized void orderDetails(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        checkOutTwoPage = new CheckOutTwoPage(getDriver());
        assertEquals(checkOutTwoPage.getInventoryItemName(),"Sauce Labs Bike Light");
    }
    @Test(description = "Verify that the user can proceed to checkout from the cart page")
    public synchronized void proceedToCheckout(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
        assertEquals(checkOutStepOnePage.getYourPagetTitle(),"Checkout: Your Information");
    }


    @Test(description = "Verify that the user can fill out the checkout information form")
    public synchronized void fillCheckoutForm(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        checkOutTwoPage = new CheckOutTwoPage(getDriver());
        assertEquals(checkOutTwoPage.getYourPagetTitle(),"Checkout: Overview");
    }


    @Test(description = "Verify that the user can complete the order on the checkout overview page")
    public synchronized void completeTheOrder(){

        loginMethod(getDriver());

        inventoryPage = new InventoryPage(getDriver());
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnShopingCartIcon();

        cartPage = new CartPage(getDriver());
        cartPage.clickOnCheckOutButton();

        checkOutStepOnePage = new CheckOutStepOnePage(getDriver());
        checkOutStepOnePage.enterFirstName("Ahmed");
        checkOutStepOnePage.enterLastName("safy");
        checkOutStepOnePage.enterPostalCode("1234");
        checkOutStepOnePage.clickOnContinueButton();

        checkOutTwoPage = new CheckOutTwoPage(getDriver());
        checkOutTwoPage.clickOnFinishButton();

        checkoutCompletePage = new CheckoutCompletePage(getDriver());

        assertEquals(checkoutCompletePage.getConforamtionMessage(),"Thank you for your order!");
    }



}
