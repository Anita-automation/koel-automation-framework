import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest { //class called LogoutTests that holds several tests//

    @Test //this is a test that TestNG should run//
    public void logStudentOutBtnVisible() { //this method is visible to everyone and doesn't return anything, it just performs an action
        LoginPage loginPage = new LoginPage(driver); //the chrome browser is inherited from the BaseTest,
        //creates a variable called loginPage of type LoginPage that makes a new LoginPage object and gives it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login(); //called from the login page, use the login() method from the LoginPage object

        homePage.verifyLogoutBtnIsVisible(); //asks the homePage object that i created to verify that logout button is visible
        //using a method inside the HomePage class
    }

    //HomePage class - the blueprint. homePage is the object -the actual thing you can use to click buttons and elements

    @Test
    public void logoutPossible() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        LoginPage loginPageAfterLogout = homePage.clickLogOutBtn();
        //On the homepage click the logout button and store it in a variable called loginPageAfterLogout as a
        //LoginPage obejct cos you are back on the login page

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
        //Print the current URL in the console, so you can see where the browser is after logout.
        Assert.assertEquals("https://qa.koel.app/", driver.getCurrentUrl());
        // Check that the current URL is exactly https://qa.koel.app/.
        //If it’s different, the test fails.
    }

    @Test
    public void LogoutAfterPasswordUpdate() {
        LoginPage loginPage = new LoginPage(driver); //create a LoginPage object and give it a browser
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();

        homePage.openProfile();

        profilePage.updatePassword("AnitaAnita1030@@", "AnitaAnita1030@@");

        LoginPage loginPageAfterLogout = homePage.clickLogOutBtn();

        loginPageAfterLogout.waitUntilLoginPageVisible();

    }
}