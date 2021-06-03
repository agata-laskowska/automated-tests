package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDeliveryAddressPage {

    private WebDriver driver;

    public SelectDeliveryAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "processAddress")
    private WebElement goToNextStepButton;

    public void waitUntilGoToNextStepButtonIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(goToNextStepButton));
    }

    public void goToNextStep() {
        goToNextStepButton.click();
    }
}
