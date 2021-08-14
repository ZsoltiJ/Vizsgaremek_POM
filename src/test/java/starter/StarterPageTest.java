package starter;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StarterPage;


public class StarterPageTest extends BaseTest {


     StarterPage starterPage;

    @Test
    @DisplayName("TC-02, A nyelv kiválasztása a honlapon.")
    public void clickEnglishButtonTest() {
        starterPage = new StarterPage(getDriver());
        starterPage.navigateToWikipedia();
        MainPage mainPage = starterPage.englishButtonClick();
        String actual = mainPage.getWikiText();
        String expected = "Welcome to Wikipedia,";

        Assertions.assertEquals(expected, actual);
    }

}
