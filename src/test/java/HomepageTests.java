import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomepageTests extends BaseTest{

    @Test
    public void recentlyPlayedIsVisible() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        assertTrue(homePage.isRecentlyPlayedVisible());
    }

    @Test
    public void viewAllNextToRecentlyPlayed() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        WebElement recentlyPlayed = homePage.getRecentlyPlayedSection();
        WebElement viewAll = homePage.getViewAllButton();

        int recentlyPlayedX = recentlyPlayed.getLocation().getX();
        int viewAllX = viewAll.getLocation().getX();

        Assert.assertTrue(
                viewAllX > recentlyPlayedX, "View All button should appear to the right of Recently Played button");

    }

    @Test
    public void recentlyAddedSongsIsVisible() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        assertTrue(homePage.isRecentlyAddedVisible());
    }

    @Test
    public void musicPanelFields() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        homePage.isHomeBtnVisible();
        homePage.isQueueBtnVisible();
        homePage.isAllSongsBtnVisible();
        homePage.isAlbumsBtnVisible();
        homePage.isArtistsBtnVisible();
    }

@Test
    public void isAboutBtnVisibleAndClickable() {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.login();

    homePage.isAboutBtnVisibleAndClickable();
}

@Test
    public void isPopUpVisible() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();
        homePage.isAboutBtnVisibleAndClickable();
        homePage.isPopUpVisible();
}

}
