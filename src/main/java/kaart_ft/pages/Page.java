package kaart_ft.pages;

import kaart_ft.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;

/**
 * Base Page Class with methods and general UI elements
 */
public abstract class Page {
    public WebDriver driver;

    public final static String BASE_URL = ConfigProperties.getProperty("site.url");

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public abstract void open();

    protected void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnButton(WebElement element) {
        element.click();
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param seconds amount of seconds
     * @param locator elements which is expected
     */
    public void waitElement(String locator, long seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * @param seconds       amount of seconds
     * @param locator       elements which is expected
     * @param needClickable - boolean value, true if element should be clickable
     */
    public void waitElement(String locator, long seconds, boolean needClickable) {
        if (needClickable) {
            new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } else {
            waitElement(locator, seconds);
        }
    }

    /**
     * @param seconds amounts of seconds without any settings
     */
    public void waitElement(double seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens page by given URL.
     *
     * @param url page address
     */
    public void openPage(String url) {
        getDriver().get(url);
    }

    /**
     * @param element elements which Xpath we would like to receive
     * @return Xpath of the current element
     */
    public static String getXPathFromElement(WebElement element) {
        String elementDescription = element.toString();
        return elementDescription.substring(elementDescription.lastIndexOf("-> ") + 9, elementDescription.lastIndexOf("]"));
    }

    public String getAtribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
