package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By signupName = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmail = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");
    private By signupAccountInfoHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterLoginEmail(String email){
        driver.findElement(loginEmail).clear();
        driver.findElement(loginEmail).sendKeys(email);
    }

    public void enterLoginPassword(String pass){
        driver.findElement(loginPassword).clear();
        driver.findElement(loginPassword).sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void enterSignupName(String name){
        driver.findElement(signupName).clear();
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email){
        driver.findElement(signupEmail).clear();
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignup(){
        driver.findElement(signupButton).click();
    }

    public boolean isLoggedIn() {
        try {
            return driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorDisplayed(){
        try {
            return driver.findElement(loginError).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public boolean isSignupAccountInfoDisplayed(){
        try {
            return driver.findElement(signupAccountInfoHeader).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
