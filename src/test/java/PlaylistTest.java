import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import Pages.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PlaylistTest extends BaseTest{

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage (driver);
        PlaylistPage playlist = new PlaylistPage(driver);

        loginPage.login();

        playlist.openPlaylist("/html/body/div[1]/div/div/nav/section[2]/ul/li[3]/a");
        playlist.deletePlaylist();
        playlist.verifyPlaylistDeleted("Test Pro Playlist");
    }

    @Test
    public void clickCreateNewPlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);

        homePage.clickCreateNewPlaylist();
        homePage.waitForNewPlaylistModal();

        assertTrue(homePage.isNewPlaylistVisible());
        assertTrue(homePage.isNewSmartPlaylistVisible());


    }

    @Test
    public void areBtnsVisible() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);

        homePage.isFavoritesBtnVisible();
        homePage.isRecentlyPlayedBtnVisible();

    }

    @Test
    public void playlistBtnsAreNotVisible() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.AssertPlaylistBtnsNotPresent("Smart playlists");
        homePage.AssertPlaylistBtnsNotPresent("User's created playlists");
    }



}

