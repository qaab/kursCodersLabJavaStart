import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.com");

        driver.findElement(By.name("q")).sendKeys("Abrakadabra");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("Abrakadabra"));



    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}