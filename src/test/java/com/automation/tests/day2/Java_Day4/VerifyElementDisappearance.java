package com.automation.tests.day2.Java_Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyElementDisappearance {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);
        if (driver.findElements(By.id("disappearing_button")).size() == 0) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        List<WebElement> buttons = driver.findElements(By.tagName("buttons"));
        for (WebElement list : buttons ) {
            list.click();
            Thread.sleep(2000);
        }
        driver.close();
    }
}