package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainMenuPage;
import pages.SubcategoryPage;

public class GoToSubcategoryTest extends BaseTest {

    @Test
    public void goToSubcategory() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        SubcategoryPage subcategoryPage = new SubcategoryPage(driver);

        mainMenuPage.clickSelectedCategory(1);

        categoryPage.waitUntilCategoryPageHeadingIsVisible();
        categoryPage.clickSubcategoryImage();

        subcategoryPage.waitUntilSubcategoryHeadingIsVisible();

        String subcategoryHeaderText = subcategoryPage.getTextOfSubcategoryHeading();

        Assert.assertTrue(subcategoryPage.subcategoryHeadingIsVisible());
    }
}
