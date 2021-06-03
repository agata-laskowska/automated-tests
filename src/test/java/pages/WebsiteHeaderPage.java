package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebsiteHeaderPage {

    private WebDriver driver;

    public WebsiteHeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public void enterKeyword() {
        searchBar.sendKeys("dress");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void search() {
        searchButton.sendKeys(Keys.ENTER);
    }
}
