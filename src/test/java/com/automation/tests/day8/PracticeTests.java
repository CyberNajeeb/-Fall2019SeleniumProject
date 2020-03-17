package com.automation.tests.day8;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        chromeOptions.setAcceptInsecureCerts(true);

        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.wait(2);
    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
    @Test
    public void test(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String result = driver.findElement(By.tagName("h4")).getText();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        MethodsContainer.verifyEquals(expected, actual);
        driver.findElement(By.xpath("//div//a")).click();
        BrowserUtils.wait(2);

//        if (result.equals("Welcome to the Secure Area. When you are done click logout below.")){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//            System.out.println("Expected: Welcome to the Secure Area. When you are done click logout below." );
//            System.out.println("Actual: " + driver.findElement(By.tagName("h4")).getText());
//        }
    }
    @Test
    public void forgotPasswordTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.name("email")).sendKeys("abc123@xyz.com", Keys.ENTER);
        driver.findElement(By.tagName("h4")).getText();
        BrowserUtils.wait(2);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected, actual);

        System.out.println(driver.findElement(By.tagName("h4")).getText());


    }
    @Test
    public void checkBoxTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//input[1]")).click();
        driver.findElement(By.xpath("//input[2]")).click();
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(By.xpath("//input[1]")).isSelected());
        if (driver.findElement(By.xpath("//input[1]")).isSelected()){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
    }
}
