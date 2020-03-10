package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);

        String popUpText = driver.switchTo().alert().getText();
        System.out.println("popUpText = " + popUpText);
        driver.switchTo().alert().accept();
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }

        buttons.get(1).click();

        System.out.println("Alert: \"" + driver.switchTo().alert().getText() + "\" was dismissed");
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(2);

        buttons.get(2).click();
        String expected2 = "You have been hacked!";
        driver.switchTo().alert().sendKeys(expected2);
        BrowserUtils.wait(4);
        driver.switchTo().alert().accept();
        String actual2 = driver.findElement(By.id("result")).getText();
        System.out.println("alert Text = " + actual2);
        if (expected2.endsWith("hacked!")&&actual2.endsWith("hacked!")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            System.out.println("expected = " + expected2);
            System.out.println("actual = " + actual2);
        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}