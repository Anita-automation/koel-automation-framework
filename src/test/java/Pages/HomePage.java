package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage { /*HomePage is a child of BasePage.
It inherits: driver wait and actions and helper methods*/


    public HomePage(WebDriver givenDriver) {
        super(givenDriver); /*the constructor for home page, when create home page object, pass driver into it, connects home page to the driver*/
    }

    public void waitUntilLoaded() {
        waitForVisible(userAvatarIcon);
    }

    //--------------
    //HEADER SECTION
    //--------------

    //LOCATORS - tells selenium how to find elements on a page

    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By profileMenu = By.cssSelector("a[title='View/edit user profile']");
    private By logoutBtn = By.cssSelector("a[data-testid='btn-logout']");

    //METHODS - uses find element from BasePage, waits until it becomes visible, and returns it

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public void openProfile() {
        waitForClickable(profileMenu).click();
    }

    public LoginPage clickLogOutBtn() {
        waitForClickable(logoutBtn).click();
        return new LoginPage(driver);}

    public void profileMenuClickable() {
        waitForClickable(profileMenu).click();
        //no return, just perform the action
    }

    public boolean verifyLogoutBtnIsVisible() {
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public WebElement getProfileButton() {
        return driver.findElement(profileMenu);
    }

    public WebElement getLogoutButton() {
        return driver.findElement(logoutBtn);
    }


    //--------------
    //SIDEBAR SECTION
    //--------------

    //LOCATORS

    private By homeBtn = By.cssSelector("a[href='#!/home']");
    private By queueBtn = By.cssSelector("a[href='#!/queue']");
    private By allSongsBtn = By.cssSelector("a[href='#!/songs']");
    private By albumsBtn = By.cssSelector("a[href='#!/albums']");
    private By artistsBtn = By.cssSelector("a[href='#!/artists']");
    private By favortiesBtn = By.cssSelector("a[href='#!/favorites']");
    private By RecentlyPlayedBtn = By.cssSelector("a[href='#!/recently-played']");
    private By createNewPlaylistBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private By newPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private By newSmartPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-smart']");

    //METHODS

    public boolean isFavoritesBtnVisible() {
        return findElement(favortiesBtn).isDisplayed();
    }

    public boolean isRecentlyPlayedBtnVisible() {
        return findElement(RecentlyPlayedBtn).isDisplayed();
    }

    public void clickCreateNewPlaylist() {
        WebElement btn = findElement(createNewPlaylistBtn);

        // scroll sidebar into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);

        // wait until clickable
        waitForClickable(createNewPlaylistBtn).click();

        // force click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public boolean isNewPlaylistVisible() {
        return findElement(newPlaylist).isDisplayed();
    }

    public boolean isNewSmartPlaylistVisible() {
        return findElement(newSmartPlaylist).isDisplayed();
    }

    public boolean isHomeBtnVisible() {
        return findElement(homeBtn).isDisplayed();
    }

    public boolean isQueueBtnVisible() {
        return findElement(queueBtn).isDisplayed();
    }

    public boolean isAllSongsBtnVisible() {
        return findElement(allSongsBtn).isDisplayed();
    }

    public boolean isAlbumsBtnVisible() {
        return findElement(albumsBtn).isDisplayed();
    }

    public boolean isArtistsBtnVisible() {
        return findElement(artistsBtn).isDisplayed();
    }

    public void AssertPlaylistBtnsNotPresent(String playlistName) {
        List<WebElement> elements = driver.findElements(

                By.xpath("//*[contains(normalize-space(), \"" + playlistName + "\")]")
        );
        assertTrue(elements.isEmpty(),
                "Playlist '" + playlistName + "' SHOULD exist but was NOT found.");
    }

    //--------------
    //PLAYER SECTION
    //--------------

    //LOCATORS

    private By playerFooter = By.cssSelector("footer.player");
    private By playNextSongBtn = By.cssSelector("[data-testid='play-next-btn']");
    private By playBtn = By.xpath("//span[@role='button' and @title='Play or resume']");
    private By soundBar = By.xpath("//img[@alt='Sound bars']");
    private By albumCard = By.cssSelector("[data-test='album-card']");
    private By shuffleIcon = By.cssSelector(".fa-random");
    private By downloadIcon = By.cssSelector(".fa-download");

    //METHODS

    public void hoverOverPlayer() {
        hoverOver(playerFooter);
    }
    public void clickPlayNextSong() {
        findElement(playNextSongBtn).click();
    }
    public void clickPlayButton() {
        findElement(playBtn).click();
    }

    public boolean isSoundBarVisible() {
        return findElement(soundBar).isDisplayed();
    }

    public void hoverFirstAlbum() {
        WebElement album = wait.until(ExpectedConditions.visibilityOfElementLocated(albumCard));
        waitForClickable(albumCard).click();
        actions.moveToElement(album).perform();
    }

    public boolean isShuffleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shuffleIcon)).isDisplayed();

    }

    public boolean isDownloadVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(downloadIcon)).isDisplayed();

    }

    //--------------
    //SEARCH SECTION
    //--------------

    //LOCATORS

    private By searchField = By.cssSelector("input[name='q']");

    //METHODS

    public void clickSearchField() {
        findElement(searchField).click();
    }

    //--------------
    //CONTENT SECTION
    //--------------

    //LOCATORS

    private By recentlyPlayedSection = By.cssSelector("section.recent h1");
    private By viewAllButton = By.cssSelector("[data-testid='home-view-all-recently-played-btn']");
    private By recentlyAdded = By.xpath("//h1[text()='Recently Added']");

    //METHODS

    public boolean isRecentlyAddedVisible() {
        return driver.findElement(recentlyAdded).isDisplayed();
    }

    public boolean isRecentlyPlayedVisible() {
        return driver.findElement(recentlyPlayedSection).isDisplayed();

    }

    public boolean isViewAllVisible() {
        return driver.findElement(viewAllButton).isDisplayed();
    }

    public WebElement getRecentlyPlayedSection() {
        return driver.findElement(recentlyPlayedSection);
    }

    public WebElement getViewAllButton() {
        return driver.findElement(viewAllButton);
    }


    //--------------
    //MODALS & POPUPS SECTION
    //--------------

    //LOCATORS

    private By aboutBtn = By.cssSelector("button.about.control i.fa-info-circle");
    private By popUp = By.cssSelector("div[data-testid='about-modal']");

    //METHODS

    public boolean isPopUpVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popUp)).isDisplayed();
    }

    public void isAboutBtnVisibleAndClickable() {
        waitForClickable(aboutBtn).click();
    }

}