package loggedinmainpage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;


public class LoggedInMainPageTest extends BaseTest {

    LoggedInMainPage loggedInMainPage;
    Utils utils;


    private final By HEADERTEXT = By.xpath("//*[@id='On_this_day']");



    @Test
    @DisplayName("TC-05, Bevitt adat módosítása.")
    public void dataModifingTest() {
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.dataModifing();
        String expected = loggedInMainPage.getFirstHeadingText();
        String actual = "Renault";
        Assertions.assertEquals(expected, actual);
    }



 /*   @Test
    public void searchAndSaveToFileTest() {
        Utils utils = new Utils(getDriver());
        utils.writeToFile("//*[@id='On_this_day']", "//*[@id='mp-otd']");
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.searchAndSaveToFile();

        Assertions.assertEquals("On this day", getDriver().findElement(HEADERTEXT).getText());


    } */

    @Test
    @DisplayName("TC-08, Adadbevitel külső forrásból, folyamatosan.")
    public void sendFileFromOuterSourceTest() throws FileNotFoundException {
        utils = new Utils(getDriver());
        utils.readOuterData();
        String[] userDatas = utils.readOuterData();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.clickInSearchFieldButton();
        loggedInMainPage.clickInnerSearchField();
        for (int i = 0; i < 6; i++) {
            loggedInMainPage.sendData(userDatas[i]);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loggedInMainPage.clickOnInnerSearchButton();

        Assertions.assertTrue(loggedInMainPage.items());

    }

    @Test
    @DisplayName("TC-06, File lementése eltérő tartalom esetén.")
    public void searchAndSaveToFileTest() throws IOException {
        loggedInMainPage = new LoggedInMainPage(getDriver());

        String expectedMessage = "Successfully wrote to the file.";
        String modifiedMessage;
        modifiedMessage = loggedInMainPage.fileModifying("This is a new line");
        System.out.println(modifiedMessage);

        String actualMessage =  loggedInMainPage.searchAndSaveToFile();
        Assertions.assertEquals(expectedMessage, actualMessage);


    }

    @Disabled
    @Test
    @DisplayName("TC-07, File nem kerül lementésre, azonos tartalom esetén.")
    public void searchAndSaveToFileTest2() throws IOException {
        loggedInMainPage = new LoggedInMainPage(getDriver());

        String expectedMessage = "This file has not modified.";

        String actualMessage;
        loggedInMainPage.searchAndSaveToFile();
        actualMessage = loggedInMainPage.searchAndSaveToFile();

        Assertions.assertEquals(expectedMessage, actualMessage);


    }

}