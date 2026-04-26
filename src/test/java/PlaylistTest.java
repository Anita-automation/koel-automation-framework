import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

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
}

