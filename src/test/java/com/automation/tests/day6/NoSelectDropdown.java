package com.automation.tests.day6;

import com.automation.tests.utilities.*;
import org.openqa.selenium.*;
import java.util.*;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();//to expand dropdown
        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link: allLinks){
            System.out.println(link.getText()+" : "+link.getAttribute("href"));
        }
        driver.findElement(By.linkText("Etsy")).click();//click on option
        BrowserUtils.wait(3);
        driver.quit();
    }
}