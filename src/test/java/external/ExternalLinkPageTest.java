package external;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.ExternalLinkPage;
import pages.LoggedInMainPage;
import pages.MainPage;
import pages.SpecialPages;

public class ExternalLinkPageTest extends BaseTest {

    ExternalLinkPage externalLinkPage;
    LoggedInMainPage loggedInMainPage;
    MainPage mainPage;
    SpecialPages specialPages;


    public final String FINDLINKNAME = "en.wikipedia.org/";
    public final By INPUTFIELD = By.xpath("//*[@id=\"ooui-php-1\"]");


    private String data;

    @Test
    @DisplayName("TC-10, Új adat küldése.")
    public void newDataSendTest(){
     /*   mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton(); */
        externalLinkPage = new ExternalLinkPage(getDriver());
        externalLinkPage.getURL();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.clickOnSpecPageButton();
        specialPages = new SpecialPages(getDriver());
        specialPages.clickOnExternalLink();



        Assertions.assertEquals(48, externalLinkPage.newDataSend(FINDLINKNAME));



    }


    @Test
    @DisplayName("TC-12, Adat(ok) törlése.")
    public void deleteSendedDataTest(){
       /* mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton(); */
        externalLinkPage = new ExternalLinkPage(getDriver());
        externalLinkPage.getURL();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.clickOnSpecPageButton();
        specialPages = new SpecialPages(getDriver());
        specialPages.clickOnExternalLink();
        externalLinkPage.newDataSend(FINDLINKNAME);
        externalLinkPage.deleteSendedData();



        Assertions.assertTrue(externalLinkPage.checkSpecialInputField());


    }



}


