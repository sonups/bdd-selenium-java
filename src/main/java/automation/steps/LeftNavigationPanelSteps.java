package automation.steps;

import automation.core.DriverFactory;
import automation.core.WebDriverHelper;
import automation.pages.twitter.LeftNavigationPanel;
import io.cucumber.java.en.Given;

public class LeftNavigationPanelSteps {

    LeftNavigationPanel leftNavigationPanel = new LeftNavigationPanel(DriverFactory.getDriver());

    @Given("^I click on (.*?) button in left navigation panel$")
    public void loginToTwitter(String button) {
        WebDriverHelper.waitForPageLoad();
        switch (button) {
            case "profile":
                leftNavigationPanel.clickProfileButton();
                break;
            case "home":
                leftNavigationPanel.clickHomeButton();
                break;
        }
        WebDriverHelper.waitForPageLoad();
    }

}
