package searchresult;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import pages.SearchResultPage;



public class SearchResultPageTest extends BaseTest {

    SearchResultPage searchResultPage;
    LoggedInMainPage loggedInMainPage;

    private final By FIRSTCONTROL = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]");



    @Test
    @DisplayName("TC-11, Többoldalas lista bejárása.")
    public void morePagesListsTest() {

        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.morePagesLists("letter types");
        searchResultPage = new SearchResultPage(getDriver());
        searchResultPage.clickOnFirst500Button();
        searchResultPage.clickOnNext500Button();
        searchResultPage.morePagesLists();

        Assertions.assertTrue(searchResultPage.firstWord() || searchResultPage.secondWord());


    }


}
