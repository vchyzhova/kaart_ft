package kaart_ft.pages;

import kaart_ft.pages.Page;
import kaart_ft.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Page{
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void open(){
        driver.get(ConfigProperties.getProperty("site.url"));
    }

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement logoHomePage;
}
