package com.enable.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    //variables
   public static WebDriver driver ;


   @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("https://www.saucedemo.com/");
    }

    public WebDriver getDriver(){
       return driver;
    }







    @AfterMethod
    public void closeBrowser(){
       driver.quit();
    }

}
