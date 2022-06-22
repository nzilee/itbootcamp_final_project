package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage (){
        navPage.getLanguagesButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 20)
    public void checksInputTypes (){
        navPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInput()
                        .getAttribute("type"),
                "email",
                "Email input 'type' attribute is not 'email'");

        Assert.assertEquals(loginPage.getPasswordInput()
                        .getAttribute("type"),
                "password",
                "Password input 'type' attribute is not 'password'");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist (){
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getMessageTextFromPopUp()
                        .getText(),
                "User does not exists",
                "The pop-up message does not contain 'User does not exists' text");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong (){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getMessageTextFromPopUp()
                        .getText(),
                "Wrong password",
                "The message in pop-up dialogue is not as expected");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 50)
    public void login () {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/home");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/home"),
                "Current URL does not contain '/home' route");
    }

    @Test(priority = 60)
    public void logout(){
        Assert.assertTrue(navPage.getLogoutButton()
                        .isDisplayed(),
                "The 'Logout' button is not visible on the current page");
        navPage.getLogoutButton().click();
    }
}
