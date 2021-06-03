package tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import UtilClasses.GetTestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static JSONObject testData;

    @BeforeMethod
    public void initializeDriver() throws IOException, ParseException {
        GetTestData readTestData = new GetTestData();
        testData = readTestData.getTestData();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }
}
