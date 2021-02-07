package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class SearchProductTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(driver);

        homePage.enterKeyword();
    }
}
