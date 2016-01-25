package kaart_ft;

import com.google.common.base.Strings;
import kaart_ft.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by v.chyzhova on 24-Jan-16.
 */
// @Listeners({ScreenShotOnFailure.class})
    public class BaseTest {

        private static WebDriver driver;


        public void createDriver() {
            //final String username = System.getenv("SAUCE_USER_NAME");
            //final String accessKey = System.getenv("SAUCE_API_KEY");
            driver = new FirefoxDriver();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            String seleniumBrowser = "firefox";//System.getenv("SELENIUM_BROWSER");
            if (!Strings.isNullOrEmpty(seleniumBrowser)) {
                desiredCapabilities.setBrowserName(seleniumBrowser);
            }
            final String seleniumVersion = "41";//System.getenv("SELENIUM_VERSION");
            if (!Strings.isNullOrEmpty(seleniumVersion)) {
                desiredCapabilities.setVersion(seleniumVersion);
            }


            /*final String username = ConfigProperties.getProperty("SAUCE_USER_NAME");
            final String accessKey = ConfigProperties.getProperty("SAUCE_API_KEY");
            if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(accessKey)) {
                driver = new FirefoxDriver();
            } else {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                String seleniumBrowser = "firefox";//System.getenv("SELENIUM_BROWSER");
                if (!Strings.isNullOrEmpty(seleniumBrowser)) {
                    desiredCapabilities.setBrowserName(seleniumBrowser);
                }
                final String seleniumVersion = "41";//System.getenv("SELENIUM_VERSION");
                if (!Strings.isNullOrEmpty(seleniumVersion)) {
                    desiredCapabilities.setVersion(seleniumVersion);
                }

                final String seleniumPlatform = "win7";//System.getenv("SELENIUM_PLATFORM");
                if (!Strings.isNullOrEmpty(seleniumPlatform)) {
                    desiredCapabilities.setCapability(CapabilityType.PLATFORM, seleniumPlatform);
                }
                final String sauceUrl = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", username, accessKey);
                System.out.println(sauceUrl);
                try {
                    driver = new RemoteWebDriver(
                            new URL(sauceUrl),
                            desiredCapabilities);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }*/
            driver.manage().window().maximize();
}

        @AfterSuite
        public void tearDownTest() {
            driver.close();
        }

        @BeforeSuite
        public WebDriver getDriver() {
            if (driver == null) {
                createDriver();
            }
            return driver;
        }

    public int getResponseCode(String siteUrl) {
        int statusCode;
        try {
            URL url = new URL(siteUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
