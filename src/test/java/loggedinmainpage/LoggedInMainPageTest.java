package loggedinmainpage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoggedInMainPage;
import utils.Utils;

@Disabled
public class LoggedInMainPageTest extends BaseTest {



    LoggedInMainPage loggedInMainPage;


    @Test
    public void dataModifingTest() {
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.dataModifing();

        String expected = getDriver().findElement(By.xpath("//*[@id='firstHeading']")).getText();
        String actual ="Renault";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSaveToFileTest(){
        Utils utils = new Utils(getDriver());
        utils.writeToFile("//*[@id='On_this_day']", "//*[@id='mp-otd']");
        loggedInMainPage = new LoggedInMainPage(getDriver());
        loggedInMainPage.navigateUrl();
        loggedInMainPage.searchAndSaveToFile();

        Assertions.assertEquals("On this day", getDriver().findElement(By.xpath("//*[@id='On_this_day']")).getText());


    }

}
