package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column > h1 > span.cat-name")
    private WebElement categoryPageHeading;

    @FindBy(css = "#center_column > h1")
    private WebElement specialPriceCategoryPageHeading;

    @FindBy(css = "#subcategories > ul > li:nth-child(1) > div.subcategory-image > a")
    private WebElement subcategoryImage;

    @FindBy(className = "product-name")
    List<WebElement> products;

    @FindBy(css = "#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement addToCartButton;

    @FindBy(className = "navigation_page")
    private WebElement breadcrumbs;

    @FindBy(css = "#special_block_right > p > a")
    private WebElement specialCategoryBlock;

    @FindBy(css = "#viewed-products_block_left > div > ul > li > div > h5 > a")
    private WebElement nameOfTheLastViewedProduct;

    public void waitUntilCategoryPageHeadingIsVisible() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(categoryPageHeading));
    }

    public void waitUntilSpecialPriceCategoryHeadingIsVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(specialPriceCategoryPageHeading));
    }

    public String getTextOfCategoryPageHeading() {
        return categoryPageHeading.getText().trim().toLowerCase();
    }

    public String getTextOfSpecialPriceCategoryPageHeading() {
        return specialPriceCategoryPageHeading.getText().trim();
    }

    public String getTextOfBreadcrumbs() {
        return breadcrumbs.getText().toLowerCase();
    }

    public String getNameOfTheLastViewedProduct() {
        return nameOfTheLastViewedProduct.getText();
    }

    public void clickSubcategoryImage() {
        subcategoryImage.click();
    }

    public void clickProduct() {
        java.util.Iterator<WebElement> i = products.iterator();
        while (i.hasNext()) {
            WebElement element = i.next();
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }
    }

    public void clickSpecialPriceCategoryBlock() {
        specialCategoryBlock.click();
    }
}
