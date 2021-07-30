package main;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import pages.MainPage;

public class MainPageTest extends BaseTest {

    MainPage mainPage;

    @Test
    public void loginTest() {
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF9y-");
        LoggedInMainPage loggedinmainpage = mainPage.clickBlueLoginButton();
        Assertions.assertEquals("Log out", getDriver().findElement(By.xpath("//*[@id='pt-logout']/a")).getText());


    }
}