package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void TC_Login_001_validLogin(){
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginEmail("roaaosamaelethy@gmail.com");
        lp.enterLoginPassword("123456");
        lp.clickLogin();
        Assert.assertTrue(lp.isLoggedIn(), "User should be logged in and logout link visible.");
    }

    @Test
    public void TC_Login_002_invalidPassword(){
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginEmail("ValidEmail@gmail.com");
        lp.enterLoginPassword("InvalidPassword123");
        lp.clickLogin();
        Assert.assertTrue(lp.isLoginErrorDisplayed(), "Error message should be displayed for invalid password.");
    }

    @Test
    public void TC_Login_003_unregisteredEmail(){
        LoginPage lp = new LoginPage(driver);
        lp.enterLoginEmail("unregisteredEmail@example.com");
        lp.enterLoginPassword("ValidPassword123");
        lp.clickLogin();
        Assert.assertTrue(lp.isLoginErrorDisplayed(), "Error message should be displayed for unregistered email.");
    }

    @Test
    public void TC_Login_004_emptyFields(){
        LoginPage lp = new LoginPage(driver);
        lp.clickLogin();
        // site shows validation near fields; assert error present by checking not logged in
        Assert.assertFalse(lp.isLoggedIn(), "User should not be logged in when fields are empty.");
    }

}