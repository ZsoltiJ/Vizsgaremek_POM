package main;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoggedInMainPage;
import pages.MainPage;
import utils.Utils;


public class MainPageTest extends BaseTest {

    MainPage mainPage;
    Utils utils;
    LoggedInMainPage loggedInMainPage;
    private String[] temporaryFile;






    @Test
    public void invalidLoginTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF");
        mainPage.clickBlueLoginButton();
        String expected = "Incorrect username or password entered.";


        Assertions.assertTrue(mainPage.actualError().contains(expected));
    }

    @Test
    public void validLoginTest() {
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("Abcdefghijk");
        loggedInMainPage = mainPage.clickBlueLoginButton();
        String expected = "Log out";

        Assertions.assertEquals(expected, mainPage.validLog());

    }




}