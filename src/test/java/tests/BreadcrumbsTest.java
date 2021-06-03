package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;

public class BreadcrumbsTest extends BaseTest {

    @Test
    public void testBreadcrumbs() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();

        String categoryName = categoryPage.getTextOfCategoryPageHeading();
        String breadcrumbsText = categoryPage.getTextOfBreadcrumbs();

        Assert.assertEquals(categoryName, breadcrumbsText);
    }
}
