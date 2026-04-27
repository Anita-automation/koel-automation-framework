import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayTest extends BaseTest{

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);

        // Login using your Page Object
        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        dsfasfasas

        // Interact with the player using HomePage methods
        homePage.hoverOverPlayer();
        homePage.clickPlayButton();

        Assert.assertTrue(homePage.isSoundBarVisible());
    }
}





