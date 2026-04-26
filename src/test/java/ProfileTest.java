import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() {
        LoginPage login = new LoginPage(driver);
        ProfilePage profile = new ProfilePage(driver);

        login.navigateToPage()
                .provideEmail("anita.surewicz@testpro.io")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        profile.openProfile();

        String newName = profile.generateRandomName();
        profile.changeProfileName(newName);

        profile.verifyProfileNameUpdated(newName);
    }
}


