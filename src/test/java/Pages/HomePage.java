package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
}

/*RENAME PLAYLIST
        *import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "AnitaAgain";

    @Test
    public void renamePlayList() {

        String updatedPlayListMsg = "Updated playlist \"AnitaAgain.\"";

        navigateToPage();
provideEmail("anita.surewicz@testpro.io");
providePassword("AnitaAnita1029");
clickLoginButton();
doubleClickPlayList();
enterNewPlayListName();
        Assert.assertEquals(getRenamePlayListSuccessMsg(),updatedPlayListMsg);

        }

public void doubleClickPlayList() {
    WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    actions.doubleClick(playListElement).perform();
}

public void enterNewPlayListName() {
    WebElement newPlayListName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
    newPlayListName.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
    newPlayListName.sendKeys(newPlaylistName);
    newPlayListName.sendKeys(Keys.ENTER);

}

public String getRenamePlayListSuccessMsg() {
    WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    return notification.getText();
}

}
*
* from co-pilot: public void doubleClickPlayList() {
        WebElement playListElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".playlist:nth-child(3)")
            )
        );
        actions.doubleClick(playListElement).perform();
    }

    public void enterNewPlayListName(String newName) {
        WebElement newPlayListName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='name']")
            )
        );
        newPlayListName.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        newPlayListName.sendKeys(newName);
        newPlayListName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlayListSuccessMsg() {
        WebElement notification = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.success.show")
            )
        );
        return notification.getText();
    }
}
* */

