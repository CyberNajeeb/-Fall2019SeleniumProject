package com.automation.tests.day9.acttivities;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
        private WebDriver driver;
        private Actions actions;
        private By usernameBy = By.id("prependedInput");
        private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallButton = By.cssSelector("a[title='Log call']");

    @Test
    public void verifyLogCallButton(){
        WebElement logCallBtnElement = driver.findElement(logCallButton);
        logCallBtnElement.click();
        BrowserUtils.wait(5);



        //driver.findElement(logCallButton).click();
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys("storemanager85");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        driver.findElement(By.linkText("Calls")).click();


    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
    @Test
    public void test(){

    }
}
