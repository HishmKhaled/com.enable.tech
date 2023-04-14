package com.enable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage{

    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//span[@class='title']");

    private By firstNameField= By.id("first-name");

    private By lastNameField= By.id("last-name");

    private By postaCodeField= By.id("postal-code");

    private By continueButton= By.id("continue");

    private By errorMessage = By.xpath("//div[@class='error-message-container error']");


    public String getYourPagetTitle(){
        return findElement(pageTitle).getText();
    }

    public void enterFirstName(String firstName ){
        findElement(firstNameField).clear();
        findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        findElement(lastNameField).clear();
        findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        findElement(postaCodeField).clear();
        findElement(postaCodeField).sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        findElement(continueButton).click();
    }

    public String getTheErrorMessage(){
        return findElement(errorMessage).getText();
    }


}
