package automation.pages.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigationPanel {

    private WebDriver driver;

    private By homeButton = By.cssSelector("a[aria-label='Home']");
    //    private By exploreButton = By.cssSelector("a[aria-label='Search and explore']");
//    private By notificationsButton = By.cssSelector("a[aria-label^='Notifications']");
//    private By messagesButton = By.cssSelector("a[aria-label='Direct Messages']");
    private By profileButton = By.cssSelector("a[aria-label='Profile']");


    public LeftNavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }
    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

}
