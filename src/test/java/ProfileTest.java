import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfileName() {
        LoginPage login = new LoginPage(driver);
        ProfilePage profile = new ProfilePage(driver);

        login.login();

        profile.openProfile();

        String newName = profile.generateRandomName();
        profile.changeProfileName(newName);

        profile.verifyProfileNameUpdated(newName);
    }

    @Test
    public void profilePageUrlChangesButUiDoesNotLoad() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.profileMenuClickable();

        assertTrue(driver.getCurrentUrl().contains("/profile"),
                "URL did not navigate to the profile page.");

        By currentPasswordField = By.cssSelector("[name='current_password']");
        assertTrue(driver.findElements(currentPasswordField).isEmpty(),
                "Profile UI loaded, but it should not have.");
    }

    @Test
    public void profileBtnNavigatesToCorrectURL() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.profileMenuClickable();
        assertTrue(driver.getCurrentUrl().contains("/profile"));


    }
}

