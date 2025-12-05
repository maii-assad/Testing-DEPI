package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Navbar
    By homeLink = By.xpath("//a[text()=' Home']");
    By productsLink = By.xpath("//a[text()=' Products']");
    By cartLink = By.xpath("//a[text()=' Cart']");
    By loginLink = By.xpath("//a[text()=' Signup / Login']");

    // Carousel
    By carouselRight = By.cssSelector(".right.control-carousel");
    By carouselLeft = By.cssSelector(".left.control-carousel");

    // Categories
    By womenCategory = By.xpath("//a[contains(text(),'Women')]");
    By menCategory = By.xpath("//a[contains(text(),'Men')]");
    By kidsCategory = By.xpath("//a[contains(text(),'Kids')]");
    By categorySection = By.xpath("//h2[text()='Category']");

    // Brands
    By brands = By.cssSelector(".brands-name a");

    // Products
    By firstProductCard = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    By priceFirst = By.cssSelector(".features_items .productinfo h2");
    By nameFirst = By.cssSelector(".features_items .productinfo p");
    By addToCartFirst = By.xpath("(//a[text()='Add to cart'])[1]");
    By viewProductFirst = By.xpath("(//a[text()='View Product'])[1]");
    By overlayFirst = By.xpath("(//div[@class='product-overlay'])[1]");


    // Helper Scroll Method
    private void scrollTo(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }


    // Navbar methods
    public void clickHome() { waitAndClick(homeLink); }
    public void clickProducts() { waitAndClick(productsLink); }
    public void clickCart() { waitAndClick(cartLink); }
    public void clickLogin() { waitAndClick(loginLink); }

    // Carousel
    public void clickRightCarousel() { waitAndClick(carouselRight); }
    public void clickLeftCarousel() { waitAndClick(carouselLeft); }

    // Categories (fixed)
    //public void scrollToCategorySection() { scrollTo(categorySection); }
    public void scrollToCategorySection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Category']")));
    }


    public void clickWomenCategory() {
        scrollTo(womenCategory);
        waitAndClick(womenCategory);
    }

    public void clickMenCategory() {
        scrollTo(menCategory);
        waitAndClick(menCategory);
    }

    public void clickKidsCategory() {
        scrollTo(kidsCategory);
        waitAndClick(kidsCategory);
    }

    // Brands
    public int getBrandCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brands)).size();
    }

    public void clickBrand(int i) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brands)).get(i).click();
    }

    // Hover effect (fixed)
    public void hoverFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductCard));
        scrollTo(firstProductCard);

        actions.moveToElement(product).perform();

        // Ensure overlay becomes visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(overlayFirst));
    }

    // Product Actions
    public boolean isPriceVisible() { return driver.findElement(priceFirst).isDisplayed(); }
    public boolean isNameVisible() { return driver.findElement(nameFirst).isDisplayed(); }

    public void addToCart() {
        hoverFirstProduct();
        waitAndClick(addToCartFirst);
    }

    public void viewFirstProduct() {
        hoverFirstProduct();
        waitAndClick(viewProductFirst);
    }
}

