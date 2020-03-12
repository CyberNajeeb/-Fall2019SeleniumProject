package officeHour_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://automationpractice.com");

            driver.findElement(By.name("search_query")).sendKeys("tshirt", Keys.ENTER);
            System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p")).getText());

            Thread.sleep(4000);
            driver.navigate().to("http://automationpractice.com");
            driver.findElement(By.name("search_query")).sendKeys("t-shirt" + Keys.ENTER);
            System.out.println(driver.findElement(By.className("heading-counter")).getText());
            driver.quit();
        }
    }
