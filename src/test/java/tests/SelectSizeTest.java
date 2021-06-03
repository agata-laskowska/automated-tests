package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SelectSizeTest extends BaseTest {

    @Test
    public void selectSize() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartLayerPage cartLayerPage = new CartLayerPage(driver);
        MiniCartPage miniCartPage = new MiniCartPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();
        categoryPage.clickProduct();

        productPage.waitUntilProductPageLoads();
        productPage.selectSize("2");
        productPage.addProductToCart();

        cartLayerPage.waitUntilAddedToCartNotificationIsVisible();
        cartLayerPage.closeCart();

        miniCartPage.hoverShoppingCart();
        miniCartPage.waitUntilGoToCheckoutButtonIsClickable();

        String productDescription = miniCartPage.getTextOfProductDescription();

        Assert.assertTrue(productDescription.contains("M"));
    }
}
