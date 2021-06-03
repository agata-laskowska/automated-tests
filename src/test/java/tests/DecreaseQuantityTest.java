package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;
import pages.ProductPage;

public class DecreaseQuantityTest extends BaseTest {

    @Test
    public void decreaseQuantity() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();
        categoryPage.clickProduct();

        productPage.waitUntilProductPageLoads();
        productPage.increaseQuantity();

        int quantityBeforeDecreasing = productPage.getQuantity();

        productPage.decreaseQuantity();

        int quantityAfterDecreasing = productPage.getQuantity();

        Assert.assertTrue(quantityBeforeDecreasing > quantityAfterDecreasing);
    }
}
