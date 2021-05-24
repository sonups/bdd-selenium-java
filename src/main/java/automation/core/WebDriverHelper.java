package automation.core;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebDriverHelper {
    private static long actionWaitTimeout = 30;

    public static boolean clickElementHavingText(WebDriver driver, By selector, String containingText) {
        List<WebElement> webElements = driver.findElements(selector);
        if (null == webElements)
            return false;
        else if (webElements.size() == 0)
            return false;
        for (WebElement element : webElements) {
            if (element.getText().equals(containingText)) {
                element.click();
                return true;
            }
        }
        return false;
    }

    public static void waitForPageLoad() {
        RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.getDriver();
        int max_tries = 3;
        for(int i =1; i <= max_tries; i++) {

            try {
                String state = (String) driver.executeScript("return document.readyState;", new Object[0]);
                if (!"complete".equals(state)) {
                    (new WebDriverWait(driver, (long) actionWaitTimeout)).until((driver1) -> {
                        return Boolean.valueOf("complete".equals(((JavascriptExecutor) driver1)
                                .executeScript("return document.readyState;", new Object[0])));
                    });
                }
            } catch (WebDriverException var) {
                ;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getPageTitle(RemoteWebDriver driver) {
        return driver.getTitle();
    }

    public static String getCurrentWebSiteURL(RemoteWebDriver driver) {
        String currentURL = driver.getCurrentUrl();
        URL url = null;
        try {
            url = new URL(currentURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String site = new String();
        if (null != url) {
            site = url.getProtocol() + "://" + url.getHost();
        }
        return site;

    }

    public static boolean clickElementHavingText(List<WebElement> elements, String text){
        boolean found = false;
        for(WebElement element:elements){
            if(element.getText().contains(text)){
                found = true;
                element.click();
                break;
            }
        }
        waitForPageLoad();
        return found;
    }


}
