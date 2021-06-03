package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubcategoryPage {

    private WebDriver driver;

    public SubcategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column > h1 > span.cat-name")
    private WebElement subcategoryHeading;

    public void waitUntilSubcategoryHeadingIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subcategoryHeading));
    }

    public String getTextOfSubcategoryHeading() {
        return subcategoryHeading.getText();
    }

    public Boolean subcategoryHeadingIsVisible() {
        return subcategoryHeading.isDisplayed();
    }
}
