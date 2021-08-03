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


    @Test
    public void morePagesListsTest() {

        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.morePagesLists("letter types");
        searchResultPage = new SearchResultPage(getDriver());
        //searchResultPage.navToActual();
        //searchResultPage.clickOnSearchButton();
        searchResultPage.clickOnFirst500Button();
        searchResultPage.clickOnNext500Button();
        searchResultPage.morePagesLists();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]")).getText().contains("letter")
                || (getDriver().findElement(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]")).getText().contains("types")));

    }


}
