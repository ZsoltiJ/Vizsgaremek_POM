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
    public void invalidLoginTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF");
        mainPage.clickBlueLoginButton();

        String expected = "Incorrect username or password entered.";
        String actual = getDriver().findElement(By.xpath("//*[@id='userloginForm']/form/div[1]")).getText();

        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    public void validLoginTest() {
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF9y-");
        LoggedInMainPage loggedInMainPage = mainPage.clickBlueLoginButton();
        Assertions.assertEquals("Log out", getDriver().findElement(By.xpath("//*[@id='pt-logout']/a")).getText());

    }

}