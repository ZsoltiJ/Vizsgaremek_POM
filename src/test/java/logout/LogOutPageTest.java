package logout;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LogOutPage;
import pages.LoggedInMainPage;
import pages.MainPage;


public class LogOutPageTest extends BaseTest {



    LogOutPage logOutPage;
    LoggedInMainPage loggedInMainPage;
    MainPage mainPage;


    private final By LOGINBUTTONCONTROL = By.xpath("//*[@id='pt-login']/a");



    @Test
    public void loggingOutTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        mainPage.clickBlueLoginButton();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        logOutPage = new LogOutPage(getDriver());
        loggedInMainPage.logOut();
        String expected = "Log in";

        Assertions.assertEquals(expected, logOutPage.loggingOut());

    }
}
