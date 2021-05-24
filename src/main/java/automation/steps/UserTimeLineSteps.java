package automation.steps;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.UserTimeLinePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class UserTimeLineSteps {

    UserTimeLinePage userTimeLinePage = new UserTimeLinePage(DriverFactory.getDriver());

    @Then("^Verify the number of tweets in the user time line to be (\\d+)$")
    public void verifyUserTimeLineTweetCount(int expectedTweetCount) {
        String currentWebSiteURL = WebDriverHelper.getCurrentWebSiteURL(DriverFactory.getDriver());
        int actualTweetCount = userTimeLinePage.getCountOfTweetsInCUrrentUserTimeLine();
        Assert.assertTrue("The number of actual tweets is not as expected -- expected:"+expectedTweetCount + " actual:" +actualTweetCount, actualTweetCount == expectedTweetCount);
    }

    @Then("^Verify the tweet contents at index (\\d+)$")
    public void verifyUserTimeLineTweetCount(int index, DataTable tweetContentsTable) {
        WebElement tweetElement = userTimeLinePage.getTweetElementAtIndex(index);
        Map<String,String> tweetContents = userTimeLinePage.getTweetContents(tweetElement);
        String currentWebSiteURL = WebDriverHelper.getCurrentWebSiteURL(DriverFactory.getDriver());

        String accountNameActual = tweetContents.get("account-name");
        String accountIdActual = tweetContents.get("account-id");
        String tweetTextActual = tweetContents.get("account-tweet-text");

        List<Map<String, String>> credList = tweetContentsTable.asMaps();
        String accountNameExpected = credList.get(0).get("account-name");
        String accountIdExpected = credList.get(0).get("account-id");
        String tweetTextExpected = credList.get(0).get("tweet-text");

        Assert.assertTrue("Actual account name not as expected -- expecte account name:"+accountNameExpected + ":actual account name" + accountNameActual,accountNameExpected.equals(accountNameActual));
        Assert.assertTrue("Actual account id not as expected -- expecte account id:"+accountIdExpected + ":actual account name" + accountIdActual,accountIdExpected.equals(accountIdActual));
        Assert.assertTrue("Actual tweet text not as expected -- expecte account name:"+tweetTextExpected + ":actual account name" + tweetTextActual,tweetTextExpected.equals(tweetTextActual));

    }

}
