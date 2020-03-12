package com.automation.tests.day4;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) {

        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
        BrowserUtils.wait(2);
        driver.close();
    }
}
