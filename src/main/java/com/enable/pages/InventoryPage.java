package com.enable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //variables

    private By homeTitle = By.xpath("//div[@class='app_logo']");

    private By addToCartButton = By.id("add-to-cart-sauce-labs-bike-light");

    private By shopingCartContainer = By.id("shopping_cart_container");


    //methods
    public String getInventoryTitle(){
        return findElement(homeTitle).getText();
    }

    public void clickOnAddToCartButton(){
        findElement(addToCartButton).click();
    }

    public void clickOnShopingCartIcon(){
        findElement(shopingCartContainer).click();
    }


}
