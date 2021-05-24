package automation.steps;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.LeftNavigationPanel;
import automation.pages.twitter.SearchPage;
import io.cucumber.java.en.Given;

public class SearchPageSteps {

    SearchPage searchPage = new SearchPage(DriverFactory.getDriver());

    @Given("^I enter the text (.*?) in search field$")
    public void searchTwitter(String searchText) {
        searchPage.searchTwitter(searchText);
        WebDriverHelper.waitForPageLoad();
    }

    @Given("^I select the page with text (.*?) from search results")
    public void selectSearchResult(String searchText) {
        searchPage.findItemAndClick(searchText);
        WebDriverHelper.waitForPageLoad();
    }



}
