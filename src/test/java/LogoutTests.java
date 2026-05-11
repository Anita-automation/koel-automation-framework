import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void logStudentOutBtnVisible() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.verifyLogoutBtnIsVisible();
    }

    @Test
    public void logoutPossible() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        LoginPage loginPageAfterLogout = homePage.clickLogOutBtn();

        loginPageAfterLogout.waitUntilLoginPageVisible();

    }

    @Test
    public void logoutRedirectsToCorrectURL() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        //a variable called loginPageAfterLogout//
        LoginPage loginPageAfterLogout = homePage.clickLogOutBtn();
        //click logout vis the Homepage, this returns a new LoginPage object stored in loginPageAfterLogout
        loginPageAfterLogout.waitUntilLoginPageVisible();

        System.out.println("URL after logout: " + driver.getCurrentUrl());
        Assert.assertEquals("https://qa.koel.app/", driver.getCurrentUrl());
    }
}