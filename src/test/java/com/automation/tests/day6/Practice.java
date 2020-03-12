package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        craigsList();

//        WebDriver driver = MethodsContainer.createDriver("chrome");
//
//        driver.get("http://practice.cybertekschool.com/autocomplete");
//        driver.findElement(By.id("myCountry")).sendKeys("Canada", Keys.ENTER);
//        driver.findElement(By.partialLinkText("/html/body/div/div[2]/div/div/form/input")).click();
//        BrowserUtils.wait(2);
//        System.out.println("result Text = " + driver.findElement(By.id("result")).getText());
//
//        //BrowserUtils.wait(2);
//        driver.quit();
    }
    public static void craigsList (){
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("https://losangeles.craigslist.org/");

        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement each : list){
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }
        System.out.println(list.size());
        driver.quit();
    }
}
