package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bankwire")
    private WebElement bankTransferButton;

    public void waitUntilBankTransferButtonIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(bankTransferButton));
    }

    public void payByBankTransfer() {
        bankTransferButton.click();
    }
}
