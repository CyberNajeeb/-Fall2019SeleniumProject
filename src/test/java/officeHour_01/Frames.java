package officeHour_01;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Frames {
    private WebDriver driver;

    @Test
    public void framesTest(){
        driver.switchTo().frame("frame-top");
        List<WebElement> lst = driver.findElements(By.xpath("//frame"));
        for (WebElement webElement : lst) {
            driver.switchTo().frame(webElement);
            String bodyTxt = driver.findElement(By.xpath("//body")).getText();
            System.out.println("bodyTxt = " + bodyTxt);
            driver.switchTo().parentFrame();
        }
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(4);
        driver.close();
    }
}
