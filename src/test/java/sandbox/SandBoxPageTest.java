package sandbox;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import pages.MainPage;
import pages.SandBoxPage;

public class SandBoxPageTest extends BaseTest {

    SandBoxPage sandBoxPage;
    MainPage mainPage;
    LoggedInMainPage loggedInMainPage;
    private String data;


    @Test
    public void newDataTypingTest(){
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF9y-");
        mainPage.clickBlueLoginButton();
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.newDataTyping();
        sandBoxPage = new SandBoxPage(getDriver());
        sandBoxPage.inputField("What is Lorem Ipsum?  +\n" +
                              "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. \n It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. \n It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");



        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=User:Szuperteszter/sandbox&action=edit&redlink=1&preload=Template%3AUser+sandbox%2Fpreload", getDriver().getCurrentUrl());
    }

    @Test
    public void repeatedDataSendingTest() throws InterruptedException {
        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF9y-");
        mainPage.clickBlueLoginButton();
        sandBoxPage = new SandBoxPage(getDriver());
        sandBoxPage.clickOnSandboxButton();
        sandBoxPage.repeatedDataSending(data);


        Assertions.assertTrue(getDriver().findElement(By.xpath("//*[@id='wpTextbox1']")).getText().contains("Ady Endre"));

    }

    @Test
    public void deleteDataTest(){

        mainPage = new MainPage(getDriver());
        mainPage.navigateToLogin();
        mainPage.clickLoginButton();
        mainPage.sendUsername("Szuperteszter");
        mainPage.sendPassword("acbgF9y-");
        mainPage.clickBlueLoginButton();
        sandBoxPage = new SandBoxPage(getDriver());
        sandBoxPage.deleteData();

        Assertions.assertEquals(getDriver().findElement(By.xpath("//*[@id='wpTextbox1']")).getText(),
                "{{User sandbox}}\n" + "<!-- EDIT BELOW THIS LINE -->");


    }




}
