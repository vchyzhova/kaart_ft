package kaart_ft.functional;

import kaart_ft.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import kaart_ft.pages.HomePage;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by v.chyzhova on 24-Jan-16.
 */
public class ExampleTest extends BaseTest{
    private HomePage homePage;

    @BeforeTest
    public void setupTest() {
        homePage = PageFactory.initElements(getDriver(), HomePage.class);
    }

    @Test
    public void checkHomePage() {
        homePage.open();
        assertTrue(homePage.logoHomePage.isDisplayed());
    }

}
