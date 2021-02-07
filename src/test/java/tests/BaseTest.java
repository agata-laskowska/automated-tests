package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

    @AfterSuite
    public void quitDriver() {
       // driver.quit();
    }
}
