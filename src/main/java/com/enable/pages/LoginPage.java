package com.enable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //constractor

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //locators

    private By usernameLocator = By.id("user-name");

    private By passwordLocator = By.id("password");

    private By loginButton = By.id("login-button");

    //methods
    public  void enterUsername(String username){
        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(username);
    }

    public  void enterPassword(String password){

        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(password);
    }

    public  void clickOnLogin(){
        findElement(loginButton).click();
    }


}
