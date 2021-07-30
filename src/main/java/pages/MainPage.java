package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final By wikiText = By.id("mp-welcome");

    WebDriver webdriver;

    public MainPage(WebDriver webdriver){
      this.webdriver = webdriver;
    }
    public String getWikiText(){
         String text =  webdriver.findElement(wikiText).getText();
         return text;
    }


}
