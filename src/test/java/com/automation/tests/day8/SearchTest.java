package com.automation.tests.day8;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;

    @Test(description = "Search java keyword on google")
    public void googleSearch(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            //searchItem.getText();
            String var = searchItem.getText();
            if (!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }
    @Test(description = "Search for java book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        for (WebElement searchItem :
                searchItems) {
            System.out.println(searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(3);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println("productTitleString = " + productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));

    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
