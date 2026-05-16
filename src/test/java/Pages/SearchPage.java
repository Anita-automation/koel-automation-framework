package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

        By searchField = By.cssSelector("input[name='q']");

    public void typeSearchQuery(String songTitle) {
        findElement(searchField).sendKeys(songTitle);

    }

}
