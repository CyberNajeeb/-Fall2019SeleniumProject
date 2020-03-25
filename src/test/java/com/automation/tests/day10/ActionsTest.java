package com.automation.tests.day10;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    WebDriver driver;
    Actions actions;

    @Test
    public void hoverTest(){
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        actions.moveToElement(img1).pause(2000).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        actions.moveToElement(img2).pause(2000).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

        actions.moveToElement(img3).pause(2000).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());

    }

    @Test
    public void jQueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");

        WebElement enabledBtn = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        WebElement downLoadBtn = driver.findElement(By.xpath("//a[@id='ui-id-4']"));
        WebElement pdfFinder = driver.findElement(By.xpath("//a[@id='ui-id-5']"));

        actions.moveToElement(enabledBtn).pause(2000).perform();
        BrowserUtils.wait(2);
        actions.moveToElement(downLoadBtn).pause(2000).perform();
        BrowserUtils.wait(2);
        actions.moveToElement(pdfFinder).pause(2000).click();

        BrowserUtils.wait(2);

    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(0);
        WebElement smallCrcl = driver.findElement(By.id("draggable"));
        WebElement largeCrcl = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(smallCrcl, largeCrcl).pause(1000).perform();
        BrowserUtils.wait(5);
        String expectedTxt = "You did great!";
        String actual = largeCrcl.getText();

        BrowserUtils.wait(3);
        Assert.assertEquals(expectedTxt, actual);
    }

    @BeforeMethod
    public void setup(){
        driver = MethodsContainer.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        actions  = new Actions(driver);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.close();
    }
}
