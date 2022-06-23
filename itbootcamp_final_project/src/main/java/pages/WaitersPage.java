package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersPage {

    private WebDriverWait wait;

    public WaitersPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void waitForURLToContain(String urlFraction){
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }
}
