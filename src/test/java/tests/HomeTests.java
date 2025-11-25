package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class HomeTests extends BaseTest {

    // TC_HOME_001
    @Test
    public void verifyNavbarLinks() {
        HomePage home = new HomePage(driver);

        home.clickHome();
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"), "Home link failed!");

        home.clickProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Products link failed!");

        home.clickCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart link failed!");
    }

    // TC_HOME_002
    @Test
    public void verifyCarouselArrows() {
        HomePage home = new HomePage(driver);
        home.clickRightCarousel();
        home.clickLeftCarousel();
    }

    // TC_HOME_003
    @Test
    public void verifyCategories() {
        HomePage home = new HomePage(driver);

        home.scrollToCategorySection();

        home.clickWomenCategory();
        Assert.assertTrue(driver.getCurrentUrl().contains("Women"), "Women category failed!");

        driver.navigate().back();

        home.clickMenCategory();
        Assert.assertTrue(driver.getCurrentUrl().contains("Men"), "Men category failed!");

        driver.navigate().back();

        home.clickKidsCategory();
        Assert.assertTrue(driver.getCurrentUrl().contains("Kids"), "Kids category failed!");
    }


    // TC_HOME_004
    @Test
    public void verifyBrands() {
        HomePage home = new HomePage(driver);

        Assert.assertTrue(home.getBrandCount() > 0, "No brands were found!");

        home.clickBrand(0);
        Assert.assertTrue(driver.getCurrentUrl().contains("brand"), "Brand page did not open!");
    }

    // TC_HOME_005
    @Test
    public void verifyHoverEffect() {
        HomePage home = new HomePage(driver);

        // Wait + scroll to product section
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productCard);

        // Hover
        Actions act = new Actions(driver);
        act.moveToElement(productCard).perform();

        // Check Add to cart visible
        WebElement addToCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Add to cart'])[1]"))
        );

        Assert.assertTrue(addToCart.isDisplayed());
    }

    // TC_HOME_006
    @Test
    public void verifyAddToCart() {
        HomePage home = new HomePage(driver);
        home.addToCart();
        Assert.assertTrue(driver.getPageSource().contains("added"), "Add to cart failed!");
    }

    // TC_HOME_007
    @Test
    public void verifyViewProduct() {
        HomePage home = new HomePage(driver);
        home.viewFirstProduct();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "Product details page did not open!");
    }

    // TC_HOME_008
    @Test
    public void verifyPriceDisplay() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isPriceVisible(), "Price not visible!");
    }

    // TC_HOME_009
    @Test
    public void verifyNameDisplay() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isNameVisible(), "Name not visible!");
    }

    // TC_HOME_010
    @Test
    public void verifyCartIcon() {
        HomePage home = new HomePage(driver);
        home.clickCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page did not open!");
    }

    // TC_HOME_011
    @Test
    public void verifySignupLoginPage() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login page did not open!");
    }
}
