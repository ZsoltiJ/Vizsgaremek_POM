package starter;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StarterPage;


public class StarterPageTest extends BaseTest {


     StarterPage starterPage;

    @Test
    public void clickEnglishButtonTest() {
        starterPage = new StarterPage(webdriver);
        starterPage.navigateToWikipedia();
        MainPage mainPage = starterPage.englishButtonClick();
        String actual = mainPage.getWikiText();
        String expected = "Welcome to Wikipedia,";
        Assertions.assertEquals(expected, actual);
    }

}
