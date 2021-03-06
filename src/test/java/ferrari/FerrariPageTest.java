package ferrari;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FerrariPage;
import pages.LoggedInMainPage;


public class FerrariPageTest extends BaseTest {


    FerrariPage ferrariPage;
    LoggedInMainPage loggedInMainPage;


    @Test
    @DisplayName("TC-09, Ellenőrizze, hogy a megjelölt, megfelelő adatot találja meg, listaként járja be weboldalt és a találatokat számolja meg.")
    public void dataListTest(){
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.sendSearchWord("Ferrari");
        ferrariPage= new FerrariPage(getDriver());
        int expected = 550;
        int actual = ferrariPage.searchCarName("Ferrari");

        Assertions.assertEquals(expected, actual);


    }

}