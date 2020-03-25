package com.automation.tests.day13;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.ConfigReader;
import com.automation.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTest {
WebDriver driver;

    @Test
    public void vytrackTest() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.id(ConfigReader.getProperty(
                "userNameLocator"))).sendKeys(ConfigReader.getProperty("store_manager"));

        Driver.getDriver().findElement(By.id(ConfigReader.getProperty(
                "passwordLocator"))).sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);

        BrowserUtils.wait(1);

        Driver.closeDriver();
    }
}