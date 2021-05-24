package automation.pages.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By logInButton = By.cssSelector("a[href='/login']");
    private By usernameInput = By.cssSelector("input[name=\"session[username_or_email]\"]");
    private By passwordInput = By.cssSelector("input[name=\"session[password]\"]");
    private By secondloginButton = By.xpath("//span[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton(){
        driver.findElement(logInButton).click();
    }
    public void typerUserNameAndPassword(String userName, String password){
        driver.findElement(usernameInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginSecondButton(){
        driver.findElement(secondloginButton).click();
    }
}
