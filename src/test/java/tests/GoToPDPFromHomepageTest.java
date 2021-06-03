package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class GoToPDPFromHomepageTest extends BaseTest{

    @Test
    public void goToPDPFromHomepage() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.hoverProduct();
        homePage.clickMoreButton();

        productPage.waitUntilProductPageLoads();

        Assert.assertTrue(productPage.addToCartButtonIsVisible());
    }
}
