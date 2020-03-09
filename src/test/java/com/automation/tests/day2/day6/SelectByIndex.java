package com.automation.tests.day2.day6;

import com.automation.tests.day2.utilities.BrowserUtils;
import com.automation.tests.day2.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(9);
        String expectedText = "District Of Columbia";

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