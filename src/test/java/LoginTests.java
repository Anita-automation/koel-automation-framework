import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
            loginPage.provideEmail("anita.surewicz@testpro.io").providePassword("AnitaAnita1029").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
