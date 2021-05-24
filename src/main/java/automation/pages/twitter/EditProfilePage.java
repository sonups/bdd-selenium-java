package automation.pages.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

    private WebDriver driver;

    private By userDescription = By.cssSelector("textarea[name='description']");
    private By saveButton = By.cssSelector("div[data-testid='Profile_Save_Button']");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserDescription(String userDescriptionText) {
        driver.findElement(userDescription).clear();
        driver.findElement(userDescription).sendKeys(userDescriptionText);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

}
