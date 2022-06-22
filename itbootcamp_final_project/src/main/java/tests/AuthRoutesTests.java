package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl + "/home");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl + "/profile");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl + "/admin/cities");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.navigate().to(baseUrl + "/admin/users");

        waitersPage.waitForURLToContain("/login");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "Current URL does not contain '/login' route");
    }
}
