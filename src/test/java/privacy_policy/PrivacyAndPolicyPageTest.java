package privacy_policy;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PrivacyAndPolicyPage;

import java.util.List;


public class PrivacyAndPolicyPageTest extends BaseTest {

   PrivacyAndPolicyPage privacyAndPolicyPage;
   MainPage mainPage;



   @Test
   public void privacyPolicyTest() throws InterruptedException {
      privacyAndPolicyPage = new PrivacyAndPolicyPage(getDriver());
      privacyAndPolicyPage.navigateToPrivacyPolicy();
      mainPage = new MainPage(getDriver());
      mainPage.clickOnPrivacyAndPolicyButton();
      privacyAndPolicyPage.scrollDown();
      List<String> controlWords = privacyAndPolicyPage.clickOnPrivacyAndPolicyArchived();
      String actual = controlWords.toString();
      String expected = "[19 June 2021, 14 February 2018, 4 April 2012, 19 August 2008, 21 June 2006, 10 April 2005]";

      Assertions.assertEquals(expected, actual);
   }

}



