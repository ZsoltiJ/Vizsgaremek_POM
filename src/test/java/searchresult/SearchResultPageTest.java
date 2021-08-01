package searchresult;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.SearchResultPage;



public class SearchResultPageTest extends BaseTest {

    SearchResultPage searchResultPage;



    @Test
    public void morePagesListsTest() {

        searchResultPage = new SearchResultPage(getDriver());
        searchResultPage.navToActual();
        searchResultPage.sendWord("letter types");
        searchResultPage.clickOnSearchButton();
        searchResultPage.clickOnFirst500Button();
        searchResultPage.clickOnNext500Button();
        searchResultPage.morePagesLists();

        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]")).getText().contains("letter")
                || (getDriver().findElement(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[2]")).getText().contains("types")));

    }


}
