package pages;

import UtilClasses.HoverElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;

public class HomePage {

    private WebDriver driver;

    HoverElement hoverElement = new HoverElement();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product-name")
    private List<WebElement> products;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement addToCartButton;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default")
    private WebElement moreButton;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.left-block > div > a.quick-view")
    private WebElement quickViewButton;

    @FindBy(id = "slider_row")
    private WebElement homepageSlider;

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "newsletter-input")
    private WebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    private WebElement submitNewsletterButton;

    @FindBy(css = "#columns > p")
    private WebElement successfulNewsletterSubscriptionAlert;

    public void waitUntilAddToCartButtonIsVisible() {
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }

    public void waitUntilSignInButtonIsClickable() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton));
    }

    public void waitUntilHomepageSliderIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(homepageSlider));
    }

    public void hoverProduct() {
        java.util.Iterator<WebElement> i = products.iterator();
        System.out.println(products);
        while (i.hasNext()) {
            WebElement element = i.next();
            if (element.isDisplayed()) {
                hoverElement.hoverElement(element);
                //hoverElement(element);
                waitUntilAddToCartButtonIsVisible();
                break;
            }
        }
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void clickMoreButton() {
        moreButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterRandomEmailIntoNewsletterInput() {
        UUID uuid = UUID.randomUUID();
        String randomPassword = uuid + "@example.com";
        System.out.println(randomPassword);
        newsletterInput.sendKeys(randomPassword);
    }

    public void subscribeToNewsletter() {
        submitNewsletterButton.click();
    }

    public Boolean signInButtonIsVisible() {
        return signInButton.isDisplayed();
    }

    public Boolean successfulNewsletterSubscriptionAlertIsVisible() {
        return successfulNewsletterSubscriptionAlert.isDisplayed();
    }
}