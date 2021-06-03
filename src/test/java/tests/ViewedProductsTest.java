package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;
import pages.ProductPage;

public class ViewedProductsTest extends BaseTest {

    @Test
    public void testViewedProducts() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();
        categoryPage.clickProduct();

        productPage.waitUntilProductPageLoads();

        String productName = productPage.getTextOfProductHeading();

        productPage.returnToPreviousCategory();

        categoryPage.waitUntilCategoryPageHeadingIsVisible();

        String nameOfTheLastViewedProduct = categoryPage.getNameOfTheLastViewedProduct();

        Assert.assertEquals(productName, nameOfTheLastViewedProduct);
    }
}
