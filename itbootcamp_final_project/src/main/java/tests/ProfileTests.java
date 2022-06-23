package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest{

    private String email = "admin@admin.com";
    private String password = "12345";

    @Test(priority = 10)
    public void visitsTheProfilePage() {

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/home");

        driver.navigate().to(baseUrl + "/profile");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/profile"),
                "Current URL does not contain '/profile' route");

        waitersPage.waitForInputAttributeToBe("email",
                "value",
                "admin@admin.com");

        Assert.assertEquals(profilePage.getEmailInput()
                        .getAttribute("value"),
                "admin@admin.com",
                "Email input attribute 'value' is not 'admin@admin.com'");

        navPage.getLogoutButton().click();
    }

    @Test(priority = 20)
    public void checksInputTypes(){

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/home");

        navPage.getMyProfileLink().click();

        waitersPage.waitForInputAttributeToBe("email", "type", "email");

        Assert.assertEquals(profilePage.getEmailInput()
                .getAttribute("type"),
                "email",
                "Email input attribute 'type' is not 'email'");

        Assert.assertEquals(profilePage.getEmailInput()
                .getAttribute("disabled"),
                "true",
                "Email input attribute 'disabled' is not 'disabled'");

        Assert.assertEquals(profilePage.getNameInput()
                .getAttribute("type"),
                "text",
                "Name input attribute 'type' is not 'text'");

        Assert.assertEquals(profilePage.getCityInput()
                .getAttribute("type"),
                "text",
                "City input attribute 'type' is not 'text'");

        Assert.assertEquals(profilePage.getCountryInput()
                .getAttribute("type"),
                "text",
                "Country input attribute 'type' is not 'text'");

        Assert.assertEquals(profilePage.getTwitterUrlInput()
                .getAttribute("type"),
                "url",
                "Twitter URL input attribute 'type' is not 'url'");

        Assert.assertEquals(profilePage.getGitHubUrlInput()
                .getAttribute("type"),
                "url",
                "GitHub URL attribute 'type' is not 'url'");

        Assert.assertEquals(profilePage.getPhoneInput()
                .getAttribute("type"),
                "tel",
                "Phone input attribute 'type' is not 'tel'");

        navPage.getLogoutButton().click();
    }

    @Test(priority = 30)
    public void editsProfile() {

        String name = "Nikola Zivkovic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String github = "https://github.com/nzilee";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        waitersPage.waitForURLToContain("/home");

        navPage.getMyProfileLink().click();

        waitersPage.waitForInputAttributeToBe("email", "type", "email");

        profilePage.getNameInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getNameInput().sendKeys("");
        profilePage.getNameInput().sendKeys(name);

        profilePage.getPhoneInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getPhoneInput().sendKeys("");
        profilePage.getPhoneInput().sendKeys(phone);

        profilePage.getCityInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getCityInput().sendKeys("");
        profilePage.getCityInput().sendKeys(city);

        profilePage.getCountryInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getCountryInput().sendKeys("");
        profilePage.getCountryInput().sendKeys(country);

        profilePage.getTwitterUrlInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getTwitterUrlInput().sendKeys("");
        profilePage.getTwitterUrlInput().sendKeys(twitter);

        profilePage.getGitHubUrlInput().click();
        actionsPage.controlABackSpace(driver);
        profilePage.getGitHubUrlInput().sendKeys("");
        profilePage.getGitHubUrlInput().sendKeys(github);

        profilePage.getSaveButton().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp()
                        .getText().contains("Profile saved successfuly"),
                "The message from pop-up should be 'Profile saved successfully'");

        Assert.assertEquals(profilePage.getEmailInput()
                        .getAttribute("value"),
                email,
                "Email input attribute 'value' is not " + email);

        Assert.assertEquals(profilePage.getNameInput()
                        .getAttribute("value"),
                name,
                "Name input attribute 'value' is not " + name);

        Assert.assertEquals(profilePage.getCityInput()
                        .getAttribute("value"),
                city,
                "City input attribute 'value' is not " + city);

        Assert.assertEquals(profilePage.getCountryInput()
                        .getAttribute("value"),
                country,
                "Country input attribute 'value' is not " + country);

        Assert.assertEquals(profilePage.getTwitterUrlInput()
                        .getAttribute("value"),
                twitter,
                "Twitter URL input attribute 'value' is not " + twitter);

        Assert.assertEquals(profilePage.getGitHubUrlInput()
                        .getAttribute("value"),
                github,
                "GitHub URL attribute 'value' is not " + github);

        Assert.assertEquals(profilePage.getPhoneInput()
                        .getAttribute("value"),
                phone,
                "Phone input attribute 'value' is not " + phone);

        navPage.getLogoutButton().click();
    }
}
