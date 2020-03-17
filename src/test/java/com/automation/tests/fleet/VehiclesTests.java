package com.automation.tests.fleet;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

/**
 *
 ######## TASK
 under fleet package create a class called VehiclesPageTests
 In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
 create a test called verifyPageSubTitle
 - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
 user assertions for validation.
 */
public class VehiclesTests {
    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//*[@id='main-menu']/ul/li[2]/a/span");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;
    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        //click on fleet
        //driver.findElement(fleetBy).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(2);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
    }
    @Test
    public void verifyPageNumber (){
        Actions actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//label[text()='Page:']/..//input")).getAttribute("value");
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Page:']/..//input")).getAttribute("value").equals("1"));
    }
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}