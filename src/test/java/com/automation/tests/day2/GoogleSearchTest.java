package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(5000);
        WebElement news = driver.findElement(By.linkText("news"));
        news.click();
        Thread.sleep(5000);

        driver.quit();
    }
}
