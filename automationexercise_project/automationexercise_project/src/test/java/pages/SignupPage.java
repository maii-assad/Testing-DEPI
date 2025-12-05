package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By password = By.id("password");
    private By day = By.id("days");
    private By month = By.id("months");
    private By year = By.id("years");
    private By newsletter = By.id("newsletter");
    private By offers = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
    private By accountCreatedMsg = By.xpath("//*[contains(text(),'Account Created!')]");

    public SignupPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectTitleMr(){ driver.findElement(titleMr).click(); }
    public void selectTitleMrs(){ driver.findElement(titleMrs).click(); }
    public void setPassword(String pwd){ driver.findElement(password).sendKeys(pwd); }
    public void setDob(String d, String m, String y){
        // simple selects by sendKeys for stability
        driver.findElement(day).sendKeys(d);
        driver.findElement(month).sendKeys(m);
        driver.findElement(year).sendKeys(y);
    }
    public void checkNewsletter(){ driver.findElement(newsletter).click(); }
    public void checkOffers(){ driver.findElement(offers).click(); }
    public void setNameDetails(String fName, String lName){
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
    }
    public void setAddress(String a1, String a2){
        driver.findElement(address1).sendKeys(a1);
        driver.findElement(address2).sendKeys(a2);
    }
    public void setCountry(String c){ driver.findElement(country).sendKeys(c); }
    public void setState(String s){ driver.findElement(state).sendKeys(s); }
    public void setCity(String c){ driver.findElement(city).sendKeys(c); }
    public void setZip(String z){ driver.findElement(zipcode).sendKeys(z); }
    public void setMobile(String m){ driver.findElement(mobileNumber).sendKeys(m); }
    public void clickCreateAccount(){ driver.findElement(createAccountButton).click(); }

    public boolean isAccountCreated(){
        try {
            return driver.findElement(accountCreatedMsg).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
