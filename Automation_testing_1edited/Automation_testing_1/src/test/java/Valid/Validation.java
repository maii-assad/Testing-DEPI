package Valid;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class Validation {
    public static void main(String[] args) {
    }

    // test case 20 ERROR
    @Test
    public void Error(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://automationexercise.com/login");


        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("yaseen");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("yassenhappy21@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[1]/label")).click();


        Select daySelect = new Select(driver.findElement(By.id("days")));
        daySelect.selectByValue("5");

        Select MonthSelect = new Select(driver.findElement(By.id("months")));
        MonthSelect.selectByValue("8");

        Select YearSelect = new Select(driver.findElement(By.id("years")));
        YearSelect.selectByValue("2004");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");

        driver.findElement(By.className("checkbox")).click();


        driver.findElement(By.id("optin")).click();

        js.executeScript("window.scrollBy(0, 500);");

        Assert.assertTrue(driver.findElement(By.className("inline-infos")).isDisplayed());

        driver.findElement(By.id("name")).clear();

        driver.findElement(By.id("last_name")).sendKeys("nagiub");

        driver.findElement(By.id("company")).sendKeys("sons");

        driver.findElement(By.id("address1")).sendKeys("ard123");

        driver.findElement(By.id("address2")).sendKeys("street1");

        Select SelectCountry = new Select(driver.findElement(By.id("country")));
        SelectCountry.selectByValue("India");



        driver.findElement(By.id("city")).sendKeys("elminya");

        driver.findElement(By.id("zipcode")).sendKeys("123455");

        driver.findElement(By.id("mobile_number")).sendKeys("0104667549");

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
        driver.quit();


    }

    // TEST CASE 21 CART IS EMPTY
     @Test
     public void CartIsEmpty(){
         WebDriver driver = new EdgeDriver();
         driver.get("https://automationexercise.com/view_cart");


            Assert.assertTrue(driver.findElement(By.className("text-center")).getText().contains("Cart is empty!"));

            driver.findElement(By.linkText("here")).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("products"));

            driver.quit();
        }

        //TEST CASE 22 HERE TO BUY PRODUCTS
    @Test
    public void products(){
        WebDriver driver = new EdgeDriver();

        driver.get("https://automationexercise.com/view_cart");

        driver.findElement(By.linkText("here")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("products"));

        driver.quit();

    }

    //test case 23 view product
    @Test
    public void ProductDetails(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//a[contains(text(),'View Product')]")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("details"));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    //TEST CASE 24 add to cart
    @Test
    public void AddToCart(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]\n")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")).getText().contains("Added!"));
        driver.quit();


    }

    // test case 25 view cart on pop up
    @Test
    public void CartPage(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]\n")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")).getText().contains("Added!"));
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
        driver.quit();


    }

    //TEST CASE 26 continue shopping
    @Test
public void BackToShopping(){
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://automationexercise.com/products");


    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 500);");
    driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]\n")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
         Assert.assertEquals("https://automationexercise.com/products", "https://automationexercise.com/products");
        driver.quit();

    }

 //TEST CASE 27 REMOVE FROM CART
@Test
 public void RemoveFromCart(){

     WebDriver driver = new EdgeDriver();
     driver.manage().window().maximize();
     driver.navigate().to("https://automationexercise.com/products");


     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0, 500);");
     driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]\n")).click();

     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")).getText().contains("Added!"));
     driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();
     Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
     driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[6]/a/i")).click();


    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p/b")).getText().contains("Cart is empty!"));
    driver.quit();

    }

    //TEST CASE 28 MULTIPLE PRODUCTS DISPLAYED
    @Test
    public void DisplayMultipleProducts(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.linkText("View Cart")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-1\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-2\"]")).isDisplayed());
        driver.quit();


    }

    //TEST CASE 29 SEARCHBAR CASE INSENSITIVE
    @Test
    public void SearchBar(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");


        String[] searchWords = {"jeans", "JEANS", "JeAnS"};
        for (String word : searchWords) {
            WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_product']"));
            searchInput.clear();
            searchInput.sendKeys(word);
            driver.findElement(By.xpath("//*[@id='submit_search']")).click();

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }
        }

        driver.quit();

    }


    //TEST CASE 30 SEARCH BAR CLEAR AND ACCESSIBLE
    @Test
    public void SearchBarVisually(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        WebElement searchBar = driver.findElement(By.id("search_product"));
        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible");

        String placeholder = searchBar.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Search Product", "Placeholder text is incorrect");

        WebElement searchIcon = driver.findElement(By.cssSelector("button#submit_search"));
        Assert.assertTrue(searchIcon.isDisplayed(), "Search icon is not visible");

        driver.quit();

    }

    //TEST CASE 31
    @Test
    public void CheckoutPage(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/login");


        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("yaseen");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("yassenhappy21@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("yaseen123*");
        Select daySelect = new Select(driver.findElement(By.id("days")));
        daySelect.selectByValue("5");

        Select MonthSelect = new Select(driver.findElement(By.id("months")));
        MonthSelect.selectByValue("8");

        Select YearSelect = new Select(driver.findElement(By.id("years")));
        YearSelect.selectByValue("2004");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");

        driver.findElement(By.className("checkbox")).click();


        driver.findElement(By.id("optin")).click();

        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.id("first_name")).sendKeys("yaseen");

        driver.findElement(By.id("last_name")).sendKeys("nagiub");

        driver.findElement(By.id("company")).sendKeys("sons");

        driver.findElement(By.id("address1")).sendKeys("ard123");

        driver.findElement(By.id("address2")).sendKeys("street1");

        Select SelectCountry = new Select(driver.findElement(By.id("country")));
        SelectCountry.selectByValue("India");

        driver.findElement(By.id("state")).sendKeys("minya");

        driver.findElement(By.id("city")).sendKeys("elminya");

        driver.findElement(By.id("zipcode")).sendKeys("123455");

        driver.findElement(By.id("mobile_number")).sendKeys("0104667549");

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

        driver.navigate().to("https://automationexercise.com/view_cart");

        driver.findElement(By.linkText("here")).click();

        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.linkText("View Cart")).click();


        driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();

    Assert.assertTrue(driver.findElement(By.id("address_delivery")).isDisplayed(),"the adress is displayed");

    Assert.assertTrue(driver.findElement(By.id("address_invoice")).isDisplayed(),"the adress is displayed");

        js.executeScript("window.scrollBy(0, 200);");

    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_info\"]/table")).isDisplayed());

        js.executeScript("window.scrollBy(500, 0);");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        driver.quit();

    }

    //TEST CASE 32 PRODUCTS DISPLAYED CORRECTLY
    @Test
    public void ProductsDisplayedCorrectly(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();

        List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));

        Assert.assertTrue(
                products.stream().allMatch(WebElement::isDisplayed),
                "Some products are not displayed!"
        );

        driver.quit();

    }


    //TEST CASE 33 VIEW  PRODUCT DETAILS
    @Test
    public void ViewProductDetails(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.linkText("View Product")).click();
        driver.quit();

    }


    //TEST CASE 34 SEARCH BAR PRODUCT
    @Test
    public void SearchBarProduct(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        driver.findElement(By.id("submit_search")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));
        Assert.assertTrue(
                products.stream().allMatch(WebElement::isDisplayed),
                "Some products are not displayed!");
        driver.quit();

    }

    //TEST CASE 35 SIDE BAR CATEGORIES
    @Test
    public void SideBarCategories(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[3]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.quit();

        }
    // TEST CASE 36 FILTER CATEGORIES
    @Test
    public void FilterCategories(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a")).click();


        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a")).click();


        driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[3]/div[1]/h4/a")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"Kids\"]/div/ul/li[1]/a")).click();

        driver.quit();



    }

    // TEST CASE 37 PRODUCT ADDED
    @Test
    public void ProductAdded(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]\n")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4")).getText().contains("Added!"));
        driver.quit();
    }

    //TEST CASE 39 BRANDS
    @Test
    public void Brands(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        List<WebElement> brands = driver.findElements(By.className("brands-name"));

        Assert.assertTrue(brands.stream().allMatch(WebElement::isDisplayed),"elements are not displayed");

        driver.quit();

    }


    // TEST CASE 40 ClickOnBrands
    @Test
     public void ShowClickedBrandOnly(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/products");

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']\n")).click();

        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']\n")).click();

        js.executeScript("window.scrollBy(0, 300);");

        List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));
        Assert.assertTrue(
                products.stream().allMatch(WebElement::isDisplayed),
                "Some products are not displayed!");

        driver.quit();

    }

}
