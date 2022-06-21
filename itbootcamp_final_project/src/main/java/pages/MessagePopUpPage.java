package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

}
