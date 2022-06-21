package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitersPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForURLToContain(String urlFraction){
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }
}
