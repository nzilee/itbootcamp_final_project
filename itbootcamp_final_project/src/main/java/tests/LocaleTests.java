package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 10)
    public void setLocaleToES() {
        navPage.getLanguagesButton().click();
        navPage.getSpanishLanguageButton().click();

        Assert.assertTrue(navPage.getHeader()
                .getText().contains("Página de aterrizaje"),
                "Header does not contain 'Página de aterrizaje' text");
    }

    @Test(priority = 20)
    public void setLocaleToEN() {
        navPage.getLanguagesButton().click();
        navPage.getEnglishLanguageButton().click();

        Assert.assertTrue(navPage.getHeader()
                .getText().contains("Landing"),
                "Header does not contain 'Landing' text");
    }

    @Test(priority = 30)
    public void setLocaleToCN() {
        navPage.getLanguagesButton().click();
        navPage.getChineseLanguageButton().click();

        Assert.assertTrue(navPage.getHeader()
                .getText().contains("首页"),
                "Header does not contain '首页' text");
    }

    @Test(priority = 40)
    public void setLocaleToFR() {
        navPage.getLanguagesButton().click();
        navPage.getFrenchLanguageButton().click();

        Assert.assertTrue(navPage.getHeader()
                .getText().contains("Page d'atterrissage"),
                "Header does not contain 'Page d'atterrissage' text");
    }
}
