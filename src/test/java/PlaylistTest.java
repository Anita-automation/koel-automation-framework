import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import Pages.SearchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PlaylistTest extends BaseTest{

    @Test
    public void deletePlaylist() {
        LoginPage login = new LoginPage(driver);
        PlaylistPage playlist = new PlaylistPage(driver);

        login.navigateToPage()
                .provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

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
}

