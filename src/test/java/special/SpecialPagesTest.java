package special;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoggedInMainPage;
import pages.MainPage;
import pages.SpecialPages;

public class SpecialPagesTest extends BaseTest {

    LoggedInMainPage loggedInMainPage;
    SpecialPages specialPages;
    MainPage mainPage;

    private final String URL = "https://en.wikipedia.org/wiki/Special:SpecialPages";

    @Test
    public void clickOnExternalLinkTest() {
       /* mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton(); */
        specialPages = new SpecialPages(getDriver());
        specialPages.navigateToURL();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.clickOnSpecPageButton();




        Assertions.assertEquals(URL , getDriver().getCurrentUrl());

    }

}
