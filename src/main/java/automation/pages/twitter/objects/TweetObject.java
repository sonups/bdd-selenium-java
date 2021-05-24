package automation.pages.twitter.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TweetObject {

    private WebElement element;


    private By accountName = By.cssSelector("div.css-901oao.css-bfa6kz.r-18jsvk2.r-1qd0xha.r-a023e6.r-b88u0q.r-rjixqe.r-bcqeeo.r-1udh08x.r-3s2u2q.r-qvutc0");
    private By accountId = By.cssSelector("div.css-901oao.css-bfa6kz.r-m0bqgq.r-18u37iz.r-1qd0xha.r-a023e6.r-16dba41.r-rjixqe.r-bcqeeo.r-qvutc0");
    private By tweetText = By.cssSelector("div.css-901oao.r-18jsvk2.r-1qd0xha.r-a023e6.r-16dba41.r-rjixqe.r-bcqeeo.r-bnwqim.r-qvutc0");


    public TweetObject(WebElement element) {
        this.element = element;
    }

    public String getAccountName(){
        return element.findElement(accountName).getText();
    }
    public String getAccountId(){
        return element.findElement(accountId).getText();
    }
    public String getTweetText(){
        return element.findElement(tweetText).getText();
    }
    
    }
