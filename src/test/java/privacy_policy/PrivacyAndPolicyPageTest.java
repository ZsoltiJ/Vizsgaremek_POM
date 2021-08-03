package privacy_policy;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.PrivacyAndPolicyPage;


public class PrivacyAndPolicyPageTest extends BaseTest {

   PrivacyAndPolicyPage privacyAndPolicyPage;
   MainPage mainPage;

   @Test
   public void privacyPolicyTest(){
      privacyAndPolicyPage = new PrivacyAndPolicyPage(getDriver());
      privacyAndPolicyPage.navigateToPrivacyPolicy();
      mainPage = new MainPage(getDriver());
      mainPage.clickOnPrivacyAndPolicyButton();
      privacyAndPolicyPage.scrollDown();
      Assertions.assertEquals("Privacy policy", getDriver().findElement(By.xpath("//*[@id='mw-normal-catlinks']/ul/li[1]/a")).getText());
      System.out.println(getDriver().findElement(By.xpath("//*[@id='mw-normal-catlinks']/ul/li[1]/a")).getText());
   }
}



