package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork_3 {

    private WebDriver driver;

    @Test
    public void sampleTest() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Purell Hand Sanitizer", Keys.ENTER);
        Thread.sleep(2000);
    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }
    @AfterMethod
    public void teardown(){
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
