package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#uniform-cgv > span")
    private WebElement agreementCheckbox;

    @FindBy(css = "#form > p > button")
    private WebElement goToPaymentButton;

    @FindBy(css = "#order > div.fancybox-overlay.fancybox-overlay-fixed > div")
    private WebElement alert;

    public void waitUntilAgreementCheckboxIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(agreementCheckbox));
    }

    public void agreeToTermsOfService() {
        agreementCheckbox.click();
    }

    public void goToPayment() {
        goToPaymentButton.click();
    }

    public Boolean alertIsVisible() {
        return alert.isDisplayed();
    }
}
