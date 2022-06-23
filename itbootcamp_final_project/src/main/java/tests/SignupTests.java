package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test(priority = 10)
    public void visitsTheSignupPage (){
        navPage.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "Current URL does not contain '/signup' route");
    }

    @Test(priority = 20)
    public void checksInputTypes (){
        navPage.getSignUpButton().click();

        Assert.assertTrue(signupPage.getEmailInput()
                        .getAttribute("type").equals("email"),
                "Email input 'type' attribute is not 'email'");

        Assert.assertTrue(signupPage.getPasswordInput()
                        .getAttribute("type").equals("password"),
                "Password input 'type' attribute is not 'password'");

        Assert.assertTrue(signupPage.getConfirmPasswordInput()
                        .getAttribute("type").equals("password"),
                "Confirm password input 'type' attribute is not 'password'");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists (){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "Current URL does not contain '/signup' route");

        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getMessageTextFromPopUp()
                        .getText(),
                "E-mail already exists",
                "The message from pop-up does not equals with expected result");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "Current URL does not contain '/signup' route");
    }

    @Test(priority = 40)
    public void signup() {
        String name = "Nikola Zivkovic";
        String email = "nikola.zivkovic@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpButton().click();

        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();


        messagePopUpPage.waitForVerifyAccPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getMessageTextFromVerifyAccPopUp().getText(),
                "IMPORTANT: Verify your account",
                "The message from pop-up does not equals with expected result");

        messagePopUpPage.getCloseButtonFromVerifyAccPopUp().click();

        navPage.getLogoutButton().click();
    }
}
