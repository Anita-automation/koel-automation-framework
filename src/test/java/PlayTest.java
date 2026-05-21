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
        loginPage.login();

        HomePage homePage = new HomePage(driver);


        // Interact with the player using HomePage methods
        homePage.hoverOverPlayer();
        homePage.clickPlayButton();

        Assert.assertTrue(homePage.isSoundBarVisible());
    }
}





