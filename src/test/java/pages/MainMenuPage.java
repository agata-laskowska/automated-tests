package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenuPage {

    private WebDriver driver;

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
    }

        public WebElement category(int categoryNumber) {
        return driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(" + categoryNumber + ") > a"));
    }

    public void clickSelectedCategory(int categoryNumber) {
        category(categoryNumber).click();
    }
}
