package ferrari;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.FerrariPage;
import pages.LoggedInMainPage;

@Disabled
public class FerrariPageTest extends BaseTest {


    FerrariPage ferrariPage;
    LoggedInMainPage loggedInMainPage;


    @Test
    public void dataListTest(){
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.sendSearchWord("Ferrari");
        ferrariPage= new FerrariPage(getDriver());
        //ferrariPage.navFerrari();
        //ferrariPage.clickOnSearch();
        //ferrariPage.searchCarName("Ferrari");


        Assertions.assertTrue(ferrariPage.searchCarName("Ferrari"));


    }

}