package com.enable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private By confirmationMessage = By.xpath("//h2[@class='complete-header']");

    public String getConforamtionMessage(){
        return findElement(confirmationMessage).getText();
    }
}
