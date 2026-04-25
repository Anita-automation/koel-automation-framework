import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayTest extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Login using your Page Object
        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Thread.sleep(3000);

        // Interact with the player using HomePage methods
        homePage.clickPlayNextSong();
        homePage.clickPlayButton();

        Assert.assertTrue(homePage.isSoundBarVisible());
    }
}





