package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecialPages {

    WebDriver webDriver;


    public final By EXTERNALBUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[7]/a");
    private final String URL = "https://en.wikipedia.org/wiki/Special:SpecialPages";

    public SpecialPages(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public ExternalLinkPage clickOnExternalLink(){
        webDriver.findElement(EXTERNALBUTTON).click();
        return new ExternalLinkPage(webDriver);
    }
    public void navigateToURL(){

        webDriver.get(URL);
    }
    public String checkUrl(){
        String actual = webDriver.getCurrentUrl();
        return actual;
    }
}

