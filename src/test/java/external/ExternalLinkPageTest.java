package external;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
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
    public void newDataSendTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.clickOnSpecPageButton();
        specialPages = new SpecialPages(getDriver());
        specialPages.clickOnExternalLink();
        externalLinkPage = new ExternalLinkPage(getDriver());



        Assertions.assertEquals(48, externalLinkPage.newDataSend(FINDLINKNAME));



    }


    @Test
    public void deleteSendedDataTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.clickOnSpecPageButton();
        specialPages = new SpecialPages(getDriver());
        specialPages.clickOnExternalLink();
        externalLinkPage = new ExternalLinkPage(getDriver());
        externalLinkPage.newDataSend(FINDLINKNAME);
        externalLinkPage.deleteSendedData();



        Assertions.assertTrue(getDriver().findElement(INPUTFIELD).getText().isEmpty());


    }



}


