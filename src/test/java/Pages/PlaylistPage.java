package Pages; //it's in the packaged folder

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage { //PlaylistPage inherits driver, wait, actions, and helper methods from BasePage.
    public PlaylistPage(WebDriver driver) {
        super(driver);
    } //the constructor, when you write
    //PlaylistPage playlist = new PlaylistPage(driver);
    //You pass the browser into PlaylistPage → PlaylistPage passes it to BasePage → BasePage sets up wait + actions.

    // Locators
    private By deleteButton = By.cssSelector(".btn-delete-playlist"); //this tells Selenium how to find the elements
    private By successMessage = By.cssSelector("div.success.show");

    //METHODS

    // Open playlist by name, click playlist
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

