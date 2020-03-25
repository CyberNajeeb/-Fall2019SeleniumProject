package com.automation.tests.practice;

import com.automation.tests.utilities.MethodsContainer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.*;

public class ReverseString {
    public static void main(String[] args) {

        String original = "sohrabi";
        System.out.println("Buffered "+new StringBuffer(original).reverse());

        //Or -->

        String reversed = "";
        for (int i = original.length()-1; i >= 0 ; i--) {
            reversed += original.charAt(i);
        }
        System.out.println("reversed = " + reversed);
    }

    WebDriver driver;
    @Test
    public void test(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("abc", Keys.ENTER);

        for (int i = 0; i < 10; i++) {

            List<WebElement> links = driver.findElements(By.xpath("//a"));
            for (WebElement link : links) {
                System.out.println(link.getAttribute("href"));
            }
            driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]")).click();
        }
    }
}
