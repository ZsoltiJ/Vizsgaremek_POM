package searchresult;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import pages.SearchResultPage;



public class SearchResultPageTest extends BaseTest {

    SearchResultPage searchResultPage;
    LoggedInMainPage loggedInMainPage;

    private final By FIRSTCONTROL = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]");
    private final By SECONDCONTROL = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[2]/div[2]");


    @Test
    public void morePagesListsTest() {

        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.morePagesLists("letter types");
        searchResultPage = new SearchResultPage(getDriver());
        searchResultPage.clickOnFirst500Button();
        searchResultPage.clickOnNext500Button();
        searchResultPage.morePagesLists();

        Assertions.assertTrue(getDriver().findElement(FIRSTCONTROL).getText().contains("letter")
                || (getDriver().findElement(FIRSTCONTROL).getText().contains("types")));

        Assertions.assertTrue(getDriver().findElement(SECONDCONTROL).getText().contains("letter")
                || (getDriver().findElement(SECONDCONTROL).getText().contains("types")));
    }


}
