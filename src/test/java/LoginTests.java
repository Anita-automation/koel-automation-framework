import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("dfaf@gmail.com")
                .providePassword("AnitaAnita1029")
                .clickSubmit() ffff

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
}
