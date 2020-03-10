package com.automation.tests.day3;

import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        Thread.sleep(4000);
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        System.out.println("logout url = " + logout.getAttribute("href"));

        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String actualResult = driver.findElement(By.tagName("h4")).getText();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        logout.click();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed!");
            System.out.println("expected Result = " + expectedResult);;
            System.out.println("actual Result = " + actualResult);

        }
        Thread.sleep(4000);
        driver.quit();
    }
}
