import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.WebElement;
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

    @Test
    public void LogoutBtnNextToProfileBtn() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        WebElement profile = homePage.getProfileButton();
        WebElement logout = homePage.getLogoutButton(); //this finds the buttons - is connected to the HomePage

        int profileX = profile.getLocation().getX();
        int logoutX =logout.getLocation().getX(); //getLocation gives its position, getX is how far it is from the
        //left edge, it stores this number or integer in a variables called logoutX and logoutX

        Assert.assertTrue(
                logoutX > profileX, "Logout button should appear to the right of the Profile button"
                //logoutX is greater than profileX, which means it's more to the right, message will appear only
                //if the test fails
        );
    }

    @Test
    public void userCannotReenterAppAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver); //created two page object

      loginPage.login();

        homePage.clickLogOutBtn() //clicks the logout button
                //the method returns a LoginPage, so have a LoginPage object again
                .waitUntilLoginPageVisible(); //waits until the LoginPage is fully loaded

        driver.navigate().back(); //standard Selenium command that presses the back button

        Assert.assertTrue(
                loginPage.isLoginFormVisible(),
                "User should remain on Login page after pressing Back"
        );



    }

}