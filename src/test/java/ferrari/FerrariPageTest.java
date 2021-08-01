package ferrari;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FerrariPage;

public class FerrariPageTest extends BaseTest {


    FerrariPage ferrariPage;





    @Test
    public void dataListTest(){
        ferrariPage= new FerrariPage(getDriver());
        ferrariPage.navFerrari();
        ferrariPage.sendKeyWord("Ferrari");
        ferrariPage.clickOnSearch();
        ferrariPage.searchCarName("Ferrari");


        Assertions.assertTrue(ferrariPage.searchCarName("Ferrari"));


    }

}