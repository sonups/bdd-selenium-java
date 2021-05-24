package automation.pages.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    private By accountName = By.cssSelector("div[data-testid='titleContainer'] h2");
    private By tweetCount = By.cssSelector("div[data-testid='titleContainer'] h2+div");
    private By editProfile = By.cssSelector("a[href^='/settings/profile'][role='link']");
    private By userDescription = By.cssSelector("div[data-testid='UserDescription']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountName() {
        return driver.findElement(accountName).getText();
    }

    public String getTweetCount() {
        return driver.findElement(tweetCount).getText();
    }

    public void clickEditProfile() {
        driver.findElement(editProfile).click();
    }

    public String getUserDescription() {
        return driver.findElement(userDescription).getText();
    }
}
