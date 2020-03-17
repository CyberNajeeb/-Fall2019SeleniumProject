package com.automation.tests.practice;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationForm {

    private String url = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameLocator = By.cssSelector("[name='firstname']");
    private By lastNameLocator = By.cssSelector("[name='lastname']");
    private By userNameLocator = By.cssSelector("[name='username']");
    private By emailLocator = By.cssSelector("[name='email']");
    private By passwordLocator = By.cssSelector("[name='password']");
    private By phoneLocator = By.cssSelector("[name='phone']");
    private By maleLocator = By.cssSelector("[value='male']");
    private By femaleLocator = By.cssSelector("[value='female']");
    private By otherLocator = By.cssSelector("[value='other']");
    private By dateOfBirthLocator = By.name("birthday");
    private By departmentLocator = By.name("department");
    private By jobTitleBy = By.name("job_title");
//    private Select job_titleSelect = new Select(driver.findElement(By.className("job_title")));
//    private WebElement progLangCPlusElement = driver.findElement(By.id("inlineCheckbox1"));
//    private WebElement progLangJavaElement = driver.findElement(By.id("inlineCheckbox2"));
//    private WebElement progLangJsElement = driver.findElement(By.id("inlineCheckbox3"));
//    private WebElement submitBtnElement = driver.findElement(By.id("wooden_spoon"));
//    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
//    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By signUpBy = By.id("wooden_spoon");


    @Test
    public void firstNameWarningMessageTest(){
        driver.findElement(firstNameLocator).sendKeys("123");
        BrowserUtils.wait(2);
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[1]/div/small[3]"));
        Assert.assertEquals(warningMessage.getText(), "first name can only consist of alphabetical letters");
    }
    @Test
    public void registrationFormTest(){

        driver.findElement(firstNameLocator).sendKeys("Najeeb");
        BrowserUtils.wait(2);
        driver.findElement(lastNameLocator).sendKeys("Sohrabi");
        BrowserUtils.wait(2);
        driver.findElement(userNameLocator).sendKeys("NSohrabi");
        BrowserUtils.wait(2);
        driver.findElement(emailLocator).sendKeys("abc123@xyz.com");
        BrowserUtils.wait(2);
        driver.findElement(passwordLocator).sendKeys("abc123!@#ABC");
        BrowserUtils.wait(2);
        driver.findElement(phoneLocator).sendKeys("123-456-7890");
        BrowserUtils.wait(2);
        driver.findElement(maleLocator).click();
        BrowserUtils.wait(2);
        driver.findElement(femaleLocator).click();
        BrowserUtils.wait(2);
        driver.findElement(otherLocator).click();
        BrowserUtils.wait(2);
        driver.findElement(dateOfBirthLocator).sendKeys("12/12/1212");
        BrowserUtils.wait(2);

        Select departmentSelector = new Select(driver.findElement(departmentLocator));
        departmentSelector.selectByVisibleText("Accounting Office");
        BrowserUtils.wait(2);

        Select jobTitleSelector = new Select(driver.findElement(jobTitleBy));
        jobTitleSelector.selectByVisibleText("SDET");
        BrowserUtils.wait(2);

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(2);
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expected, actual);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
