package com.enable.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    //variables
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

   public static String valid_UserName = "standard_user";
    public static String valid_Password = "secret_sauce";

    @BeforeMethod
   public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        driver.set(chromeDriver);

        chromeDriver.navigate().to("https://www.saucedemo.com/");

    }

   public WebDriver getDriver(){
       return driver.get();
   }







   @AfterMethod
    public void closeBrowser(){
       getDriver().quit();
    }

}
