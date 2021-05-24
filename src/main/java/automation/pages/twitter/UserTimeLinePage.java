package automation.pages.twitter;

import automation.pages.twitter.objects.TweetObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class UserTimeLinePage {

    private WebDriver driver;

    private By userTweets = By.cssSelector("section[aria-labelledby^='accessible-list'] article[role='article']");
    private By userTweetRootSection = By.cssSelector("section[aria-labelledby^='accessible-list']>div[aria-label^='Timeline'][aria-label$='Tweets'] article[role='article']");

    public UserTimeLinePage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCountOfTweetsInCUrrentUserTimeLine() {
        return driver.findElements(userTweets).size();
    }

    public WebElement getTweetElementAtIndex(int index) {
        return driver.findElements(userTweetRootSection).get(index);
    }

    public Map getTweetContents(WebElement element){
        TweetObject tweetObject = new TweetObject(element);
        HashMap<String,String> tweetContents =  new HashMap<>();
        tweetContents.put("account-name", tweetObject.getAccountName());
        tweetContents.put("account-id", tweetObject.getAccountId());
        tweetContents.put("account-tweet-text", tweetObject.getTweetText());
        return tweetContents;
    }
}
