package automation.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public RemoteWebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else if (browser.equals("remote")) {
            String ip = System.getenv("SELENIUM_HUB_ADDRESS");
            String hubURL = new String();
            if(ip !=null)
                hubURL = "http://"+ip+":4444/wd/hub";
            else
                hubURL = "http://localhost:4444/wd/hub";
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            RemoteWebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(hubURL), capability);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            tlDriver.set(driver);
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized RemoteWebDriver getDriver() {
        return tlDriver.get();
    }
}

