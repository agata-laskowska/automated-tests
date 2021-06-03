package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a")
    private WebElement firstProductNameOnSearchResultsPage;

    public Boolean firstProductContainsKeyword() {
        return firstProductNameOnSearchResultsPage.getText().contains("Dress");
    }
}
