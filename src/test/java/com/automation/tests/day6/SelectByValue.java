package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("CO");
        String expectedText = "Colorado";
        String actualText = stateSelect.getFirstSelectedOption().getText();

        if (expectedText.equals(actualText)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}