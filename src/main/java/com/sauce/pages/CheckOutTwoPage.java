package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutTwoPage extends BasePage{

    public CheckOutTwoPage(WebDriver driver) {
        super(driver);
    }

   private By pageTitle = By.xpath("//span[@class='title']");

    private By inventoryItemName= By.xpath("//div[@class='inventory_item_name']");

    private By finishButton = By.id("finish");

    public String getYourPagetTitle(){
        return findElement(pageTitle).getText();
    }

    public String getInventoryItemName(){
        return findElement(inventoryItemName).getText();
    }

    public void clickOnFinishButton(){
        findElement(finishButton).click();
    }
}
