package com.automation.tests.day12;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;

    @Test
    public void checkBoxTest(){
        List<WebElement> webElements = driver.findElements(By.xpath("//table[1]//tbody//td//td[1]"));
        for (WebElement webElement : webElements) {
            System.out.println(webElement.isEnabled());
        }
    }
    @Test
    public void updateZipCode(){
        BrowserUtils.wait(3);
        WebElement zip = driver.findElement(By.id("//table//tbody//tr[4]//td[2]/..//td[9]"));
        String expectedZip = "21233";
        Assert.assertEquals(zip.getText(), expectedZip);
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[4]/td[13]/input")).click();
        WebElement newZip = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        newZip.clear();
        newZip.sendKeys("20002");
        BrowserUtils.wait(5);
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
//        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(4);
        driver.close();
    }
}
