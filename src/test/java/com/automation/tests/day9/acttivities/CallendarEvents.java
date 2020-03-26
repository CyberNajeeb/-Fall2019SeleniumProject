package com.automation.tests.day9.acttivities;

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

public class CallendarEvents {
    private WebDriver driver;
    private Actions actions;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span");
    private By callendarEventsBy = By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]");
    private By createCallendarBtn = By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a");
    private By ownerNameLocator = By.xpath("//*[@id='s2id_oro_calendar_event_form_calendar']/a/span[1]");
    @Test
    public void verifyLogCallButton(){
        WebElement callendaEventsBtnElement = driver.findElement(callendarEventsBy);
        callendaEventsBtnElement.click();
        BrowserUtils.wait(3);


    }
    @Test
    public void verify(){
        WebElement callendaEventsBtnElement = driver.findElement(callendarEventsBy);
        callendaEventsBtnElement.click();
        BrowserUtils.wait(3);
        driver.findElement(createCallendarBtn).click();
        BrowserUtils.wait(5);
        String username = driver.findElement(By.cssSelector("#user-menu > a")).getText();
        String ownerName = driver.findElement(ownerNameLocator).getText();
        BrowserUtils.wait(3);

        Assert.assertEquals(ownerName, " Pearl Wuckert");
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
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
