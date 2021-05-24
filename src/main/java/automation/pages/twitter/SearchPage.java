package automation.pages.twitter;

import automation.core.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPage {

    private RemoteWebDriver driver;


    private By searchInput = By.cssSelector("input[data-testid='SearchBox_Search_Input']");
    private By itemToBeClicked = By.cssSelector("li[data-testid='TypeaheadUser']");

    public SearchPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public boolean findItemAndClick(String userPageId) {
        return WebDriverHelper.clickElementHavingText(driver.findElements(itemToBeClicked), userPageId);
    }
    public void searchTwitter(String searchText){
        driver.findElement(searchInput).click();
        driver.findElement(searchInput).sendKeys(searchText);
    }


}
