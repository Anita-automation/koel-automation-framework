import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest{

    @Test
    public void userCanSearchForSong() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();

        homePage.clickSearchField();
        searchPage.typeSearchQuery("Dark Days");
    }
}
