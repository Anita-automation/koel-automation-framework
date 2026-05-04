import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver); //this creates a LoginPage object, homepage received this driver
        //and sends it to basepage, BasePage stores driver, wait, actions
        //        ↓
        //HomePage inherits everything from BasePage
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmailMissingAtSignValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anita.surewicztestpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }

    @Test
    public void loginValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    public void loginValidEmailInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("gfdgsdfgds")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    public void invalidPasswordShowsErrorState() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToPage()
                .provideEmail("anita.surewicz@testpro.io")
                .providePassword("wrongPassword")
                .clickSubmit();

        Assert.assertTrue(loginPage.waitForErrorState());
    }

    @Test
    public void loginEmptyEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    public void loginRedirectsToPreviouslySavedPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://qa.koel.app/#/albums");

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#/albums");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/home");
    }

    @Test
    public void loginEmailMissingDotSignValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anitasurewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }

    @Test
    public void loginEmailMissingDomainValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("anita.surewicz@")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }
}


