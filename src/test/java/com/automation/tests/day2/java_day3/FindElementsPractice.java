package com.automation.tests.day2.java_day3;

import com.automation.tests.day2.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("najeeb");
        driver.findElement(By.name("email")).sendKeys("123@abc.com", Keys.ENTER);
        System.out.println("Signup confirmation: " + driver.findElement(By.tagName("h3")).getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
//        WebElement submit = driver.findElement(By.xpath("//*[@id=\\'wooden_spoon\\']/i"));
//        submit.submit();
    }
}
