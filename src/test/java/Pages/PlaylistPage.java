package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By deleteButton = By.cssSelector(".btn-delete-playlist");
    private By successMessage = By.cssSelector("div.success.show");

    // Open playlist by name
    public void openPlaylist(String playlistName) {
        By playlist = By.xpath("//a[contains(@class,'playlist') and text()='" + playlistName + "']");
        waitForClickable(playlist).click();
    }

    // Delete playlist
    public void deletePlaylist() {
        waitForClickable(deleteButton).click();
    }

    // Verify deletion
    public void verifyPlaylistDeleted(String playlistName) {
        String expected = "Deleted playlist \"" + playlistName + ".\"";
        String actual = waitForVisible(successMessage).getText();

        if (!actual.equals(expected)) {
            throw new AssertionError("Expected: " + expected + " but got: " + actual);
        }
    }
}

