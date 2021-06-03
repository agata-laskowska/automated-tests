package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-heading")
    private WebElement myAccountHeading;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement signOutButton;

    public void waitUntilMyAccountHeadingIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(myAccountHeading));
    }

    public Boolean myAccountHeadingIsVisible() {
        return myAccountHeading.isDisplayed();
    }

    public void signOut() {
        signOutButton.click();
    }
}
