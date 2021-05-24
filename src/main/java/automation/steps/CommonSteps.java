package automation.steps;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.LoginPage;
import automation.pages.twitter.UserTimeLinePage;
import automation.pages.twitter.objects.SendTweetObject;
import automation.pages.twitter.objects.TweetObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class CommonSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    SendTweetObject sendTweetObject = new SendTweetObject(DriverFactory.getDriver());
    UserTimeLinePage userTimeLinePage = new UserTimeLinePage(DriverFactory.getDriver());
    @Given("^I login to twitter$")
    public void loginToTwitter(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("https://twitter.com");
        WebDriverHelper.waitForPageLoad();
        loginPage.clickLoginButton();
        WebDriverHelper.waitForPageLoad();
        loginPage.typerUserNameAndPassword(userName, password);
        loginPage.clickLoginSecondButton();
        WebDriverHelper.waitForPageLoad();
    }

    @Then("^The page contains title (.*?)$")
    public void verifyPageTitle(String title) {
        WebDriverHelper.waitForPageLoad();
        String pageTitle = WebDriverHelper.getPageTitle(DriverFactory.getDriver());
        Assert.assertTrue("The title page is not as expected, expeced:" + title + " actual: " +pageTitle, pageTitle.contains(title));
    }

    @Then("^I navigate to the uri (.*?) in the current site$")
    public void navigateToURlFromCurrentSite(String uri) {
        String currentWebSiteURL = WebDriverHelper.getCurrentWebSiteURL(DriverFactory.getDriver());
        DriverFactory.getDriver()
                .get(currentWebSiteURL+ uri);
    }

    @Then("^I send a tweet with text (.*?) with timestamp appended$")
    public void sendTweet(String tweettext) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStampString = timestamp.toString();
        String combinedBiography = tweettext + " " + timeStampString;
        sendTweetObject.sendTweet(combinedBiography);
        WebDriverHelper.waitForPageLoad();
        WebElement tweetElement = DriverFactory.getDriver().findElement(By.cssSelector("article[role='article']"));
        TweetObject tweetObject = new TweetObject(tweetElement);
        String tweetTextActual = tweetObject.getTweetText();
        Assert.assertTrue("the newly send tweet is not displayed in used timeline",combinedBiography.equals(tweetTextActual));
    }

}
