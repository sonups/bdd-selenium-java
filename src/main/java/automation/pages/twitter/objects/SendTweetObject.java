package automation.pages.twitter.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SendTweetObject {

    private RemoteWebDriver driver;


    private By editableTweetTextArea = By.cssSelector("div[data-testid^='tweetTextarea']");
    private By sendTweetButton = By.cssSelector("div[data-testid^='tweetButtonInline']");

    public SendTweetObject(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void sendTweet(String tweetText) {
        driver.findElement(editableTweetTextArea).sendKeys(tweetText);
        driver.findElement(sendTweetButton).click();
    }


}
