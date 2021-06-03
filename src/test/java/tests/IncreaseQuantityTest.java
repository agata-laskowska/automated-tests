package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;
import pages.ProductPage;

public class IncreaseQuantityTest extends BaseTest {

    @Test
    public void increaseQuantity() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();
        categoryPage.clickProduct();

        productPage.waitUntilProductPageLoads();

        int quantityBeforeIncreasing = productPage.getQuantity();

        productPage.increaseQuantity();

        int quantityAfterIncreasing = productPage.getQuantity();

        Assert.assertTrue(quantityAfterIncreasing > quantityBeforeIncreasing);
    }
}
