package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PrivacyAndPolicyPage {

    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By PRIVACYANDPOLICYBUTTON = By.id("footer-places-privacy");

    private final WebDriver webdriver;

    public PrivacyAndPolicyPage(WebDriver webdriver){

        this.webdriver = webdriver;
    }

    public void navigateToPrivacyPolicy(){

        webdriver.get(URL);
    }



    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("window.scrollBy(0, 14000)");
    }
}
