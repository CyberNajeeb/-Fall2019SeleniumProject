package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.MethodsContainer;
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

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
            BrowserUtils.wait(1);

        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }
    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
        Assert.assertEquals(rows.size(), 4);
    }
    @Test
    public void getSpecificColumn(){
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        for (WebElement email : emails) {
            System.out.println("email.getText() = " + email.getText());
        }
    }
    @Test
    public void deleteRowTest(){
        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[2]")).click();
        BrowserUtils.wait(5);
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }
    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        //System.out.printf("Column: %s, position: %s", columnName, i);
        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            System.out.printf("Column: %s, position: %s", columnName, i+"\n");
            if (columnNames.get(i).getText().equals(columnName)) {
                index = i + 1;

            }
        }
        Assert.assertEquals(index, 3);
    }
    @Test
    public void getSpecificCell() {
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(), expected);
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to true to make it work
        chromeOptions.setHeadless(true);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

}
