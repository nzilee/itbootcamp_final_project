package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/admin/cities"),
                "Current URL does not contain '/admin/cities' route");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreate_EditNewCity(){
        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditPopUpToAppear();

        Assert.assertEquals(citiesPage.getNewItemInput()
                        .getAttribute("type"),
                "text",
                "New item input 'type' attribute is not 'text'");
    }

    @Test(priority = 30)
    public void createNewCity() {
        String city = "Nikola Zivkovic's city";

        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditPopUpToAppear();

        citiesPage.getNewItemInput().sendKeys(city);
        citiesPage.getSaveButtonInEditPopUp().click();
        citiesPage.waitForEditPopUpToDisappear();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp()
                        .getText().contains("Saved successfully"),
                "The message from pop-up should be 'Saved successfully'");
    }

    @Test(priority = 40)
    public void editCity() {
        String oldCityName = "Nikola Zivkovic's city";
        String newCityName = "Nikola Zivkovic's city Edited";

        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(oldCityName);
        citiesPage.waitForNumOfRowsToBe(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getNewItemInput().click();

        actionsPage.controlABackSpace(driver);

        citiesPage.getNewItemInput().sendKeys("");
        citiesPage.getNewItemInput().sendKeys(newCityName);
        citiesPage.getSaveButtonInEditPopUp().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp()
                        .getText().contains("Saved successfully"),
                "The message from pop-up should be 'Saved successfully'");
    }

    @Test(priority = 50)
    public void searchCity(){
        String cityName = "Nikola Zivkovic's city Edited";

        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForNumOfRowsToBe(1);

        Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(),
                cityName,
                "The 'Name' column does not equals with expected result");
    }

    @Test(priority = 60)
    public void deleteCity(){
        String cityName = "Nikola Zivkovic's city Edited";

        navPage.getAdminLink().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForNumOfRowsToBe(1);

        Assert.assertEquals(citiesPage.getCellFromRow(1, 1).getText(),
                cityName,
                "The 'Name' column does not equals with expected result");

        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitForDeletePopUpToAppear();
        citiesPage.getDeleteButtonInDeletePopUp().click();

        messagePopUpPage.waitForSuccessPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp()
                        .getText().contains("Deleted successfully"),
                "The message from pop-up should be 'Deleted successfully'");
    }
}
