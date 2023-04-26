package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

   private By yourCartTitle = By.xpath("//span[@class='title']");

    private By checkOutButton = By.id("checkout");


   public String getYOurCartTitle(){
        return findElement(yourCartTitle).getText();
    }


    public void clickOnCheckOutButton(){
        findElement(checkOutButton).click();
    }





}
