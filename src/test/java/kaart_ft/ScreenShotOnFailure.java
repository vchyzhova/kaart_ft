/*
package kaart_ft;

import kaart_ft.utils.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * Created by v.chyzhova on 24-Jan-16.
 *//*

public class ScreenShotOnFailure extends TestListenerAdapter{
    */
/**
     * Set to false in order to disable taking a screen shot during test failure
     *//*

    private final static boolean screenShotOnFailure = Boolean.valueOf(ConfigProperties.getProperty("screenShotOnFailure"));
    private final static int maxScreenShot = Integer.valueOf(ConfigProperties.getProperty("maxScreenShot"));
    private final static AtomicInteger alreadySavedScreenShots = new AtomicInteger(0);

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest test = (BaseTest) tr.getInstance();
        String methodName = tr.getMethod().getMethodName();
        if (screenShotOnFailure && alreadySavedScreenShots.get() <= maxScreenShot) {
            String pathToSaveScreenShot = ConfigProperties.getProperty("pathToSaveScreenShot");
            new File(pathToSaveScreenShot).mkdirs();
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
                String fileName = methodName + "-" + dateFormat.format(new Date()) + ".png";
                Files.write(Paths.get(pathToSaveScreenShot + fileName),
                        ((TakesScreenshot) test.getDriver()).getScreenshotAs(OutputType.BYTES),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                Reporter.setEscapeHtml(false);
                Reporter.log("Saved <a href=../failedTestScreenShots/" + fileName + ">Screenshot</a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            alreadySavedScreenShots.getAndIncrement();
        }
    }
}
*/
