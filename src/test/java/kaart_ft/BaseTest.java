package kaart_ft;

import com.google.common.base.Strings;
import kaart_ft.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
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
            final String username = ConfigProperties.getProperty("SAUCE_USER_NAME");
            final String accessKey = ConfigProperties.getProperty("SAUCE_API_KEY");
            driver = new FirefoxDriver();
           
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("impl.wait")), TimeUnit.SECONDS);
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

    public void setDriver(WebDriver driver) {
        this.driver = driver;
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
