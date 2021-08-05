package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExternalLinkPage {

    WebDriver webdriver;


    public final By LINKS = By.xpath("//*[@class=\"mw-spcontent\"]//ol/li");
    public final String FINDLINKNAME = "wikipedia.org";
    public final By INPUTFIELD = By.xpath("//*[@id=\"ooui-php-1\"]");
    public final By SEARCHBUTTON = By.xpath("//*[@id=\"ooui-php-3\"]/button/span[2]");
    public final By GETLINKS = By.xpath(".//a");
    public final String URL = "https://en.wikipedia.org/w/index.php?target=gffbgngn&title=Special%3ALinkSearch";


    public ExternalLinkPage(WebDriver webDriver) {

        this.webdriver = webDriver;
    }



    public int newDataSend(String word){

        webdriver.findElement(INPUTFIELD).click();
        webdriver.findElement(INPUTFIELD).sendKeys(word);
        webdriver.findElement(SEARCHBUTTON).click();

        int counter = 0;

        List<WebElement> links = webdriver.findElements(LINKS);
        for (WebElement webElement : links) {
            WebElement item = webElement.findElement(GETLINKS);
            if ( item.getText().contains(FINDLINKNAME)){
                counter += 1;
            }

        }
                System.out.println(counter);
                return counter;

    }


    public void deleteSendedData() {


        webdriver.findElement(INPUTFIELD).click();
        webdriver.findElement(INPUTFIELD).clear();


    }



}
