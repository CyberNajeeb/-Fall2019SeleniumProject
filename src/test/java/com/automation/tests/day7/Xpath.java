package com.automation.tests.day7;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    //Following locators are for http://practice.cybertekschool.com/login website
    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    static String loginButtonLocator = "//button[contains(text(), 'Login')]";
    public static void main(String[] args) {

        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginButtonLocator)).click();
        BrowserUtils.wait(3);

        String expectedResult = "You logged into a secure area!\n×";
        String actualResult = driver.findElement(By.id("flash")).getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
            System.out.println("expected Result = " + expectedResult);
            System.out.println("actual Result = " + actualResult);
        }
        BrowserUtils.wait(3);

        driver.quit();
    }
}
