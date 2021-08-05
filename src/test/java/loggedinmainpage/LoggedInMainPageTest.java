package loggedinmainpage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import utils.Utils;

import java.io.FileNotFoundException;


public class LoggedInMainPageTest extends BaseTest {

    LoggedInMainPage loggedInMainPage;
    Utils utils;


    private final By HEADERTEXT = By.xpath("//*[@id='On_this_day']");



    @Test
    public void dataModifingTest() {
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.dataModifing();

        String expected = getDriver().findElement(By.xpath("//*[@id='firstHeading']")).getText();
        String actual = "Renault";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSaveToFileTest() {
        Utils utils = new Utils(getDriver());
        utils.writeToFile("//*[@id='On_this_day']", "//*[@id='mp-otd']");
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.searchAndSaveToFile();

        Assertions.assertEquals("On this day", getDriver().findElement(HEADERTEXT).getText());


    }

    @Test
    public void sendFileFromOuterSourceTest() throws FileNotFoundException {
        utils = new Utils(getDriver());
        utils.readOuterData();
        String[] userDatas = utils.readOuterData();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.clickInSearchFieldButton();
        loggedInMainPage.clickInnerSearchField();
        loggedInMainPage.sendData1(userDatas[0]);
        loggedInMainPage.sendData2(userDatas[1]);
        loggedInMainPage.sendData3(userDatas[2]);
        loggedInMainPage.sendData4(userDatas[3]);
        loggedInMainPage.sendData5(userDatas[4]);
        loggedInMainPage.sendData6(userDatas[5]);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loggedInMainPage.clickOnInnerSearchButton();



        Assertions.assertTrue(loggedInMainPage.items());



    }
}