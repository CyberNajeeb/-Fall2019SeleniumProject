package com.automation.tests.day12;


import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://google.com");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(4);
        driver.close();
    }
    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        BrowserUtils.wait(4);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);



        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        //WebElement userName =
                driver.findElement(By.name("username")).sendKeys("tomsmith");
        //WebElement password =
                driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitBtn = wait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));
//        userName;
//        password;
        submitBtn.click();
    }
}