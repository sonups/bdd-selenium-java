package automation.steps;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.EditProfilePage;
import automation.pages.twitter.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Timestamp;

public class ProfilePageSteps {

    ProfilePage profilePage = new ProfilePage(DriverFactory.getDriver());
    EditProfilePage editProfilePage = new EditProfilePage(DriverFactory.getDriver());

    @Then("^Verify the Biography field in profile contains text (.*?)$")
    public void verifyUserProfileBiographyField(String expectedBiographyText) {
        String biographyFieldValue = profilePage.getUserDescription();
        Assert.assertTrue("The bigraphy in profile page is not as expected -- actual value:" + biographyFieldValue + " -- expected value:" + expectedBiographyText, biographyFieldValue.contains(expectedBiographyText));
    }

    @Then("^Verify the tweet count in profile is (.*?)$")
    public void verifyUserProfileFields(String tweetCountTextExpected) {
        String tweetCountTextActual = profilePage.getTweetCount();
        Assert.assertTrue("The tweet in profile page is not as expected -- actual value:" + tweetCountTextActual + " -- expected value:" + tweetCountTextExpected, tweetCountTextExpected.equals(tweetCountTextActual));
    }

    @When("^I click edit profile button$")
    public void clickEditProfile() {
        profilePage.clickEditProfile();
        WebDriverHelper.waitForPageLoad();
    }

    @When("^I update & verify the updated biography with text (.*?) appended with timestamp")
    public void updateAndVerifyBiography(String text) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStampString = timestamp.toString();
        WebDriverHelper.waitForPageLoad();
        String combinedBiography = text + timeStampString;
        editProfilePage.setUserDescription(combinedBiography);
        editProfilePage.clickSaveButton();
        WebDriverHelper.waitForPageLoad();
        String biography = profilePage.getUserDescription();
        Assert.assertTrue("Expected and actual values of biography not same",combinedBiography.equals(biography));
    }

}
