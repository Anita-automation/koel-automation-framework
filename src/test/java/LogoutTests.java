import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void logStudentOutBtnVisible() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        homePage.verifyLogoutBtnIsVisible();
    }
}
