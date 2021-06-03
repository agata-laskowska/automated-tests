package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add_to_cart")
    private WebElement addToCartButton;

    @FindBy(css = "#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1")
    private WebElement productHeading;

    @FindBy(css = "#columns > div.breadcrumb.clearfix > a:nth-child(3)")
    private WebElement previousCategoryBreadcrumbsTrail;

    @FindBy(className = "icon-plus")
    private WebElement plusIcon;

    @FindBy(className = "icon-minus")
    private WebElement minusIcon;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInputField;

    @FindBy(id = "group_1")
    private WebElement sizeSelect;

    public void waitUntilProductPageLoads() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addToCartButton));
    }

    public String getTextOfProductHeading() {
        return productHeading.getText();
    }

    public int getQuantity() {
        String quantityString = quantityInputField.getAttribute("value").trim();
        int quantityInt = Integer.parseInt(quantityString);
        return quantityInt;
    }

    public void increaseQuantity() {
        plusIcon.click();
    }

    public void decreaseQuantity() {
        minusIcon.click();
    }

    public void returnToPreviousCategory() {
        previousCategoryBreadcrumbsTrail.click();
    }

    public void selectSize(String productSize) {
        Select size = new Select(sizeSelect);
        size.selectByValue(productSize);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public Boolean addToCartButtonIsVisible() {
        return addToCartButton.isDisplayed();
    }
}
