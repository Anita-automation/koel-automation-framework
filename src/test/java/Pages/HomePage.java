package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
}


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
}
By playNextSongBtn = By.xpath("//i[@role='button' and @title='Play next song']");
By playBtn = By.xpath("//span[@role='button' and @title='Play or resume']");
By soundBar = By.xpath("//img[@alt='Sound bars']");

/*METHODS*/

public void clickPlayNextSong() {
    findElement(playNextSongBtn).click();
}

public void clickPlayButton() {
    findElement(playButton).click();
}

public boolean isSoundBarVisible() {
    return findElement(soundBar).isDisplayed();
}

}
