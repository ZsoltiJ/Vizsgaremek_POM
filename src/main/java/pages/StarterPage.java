package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StarterPage {

    private WebDriver webdriver;
    private final String URL = "https://www.wikipedia.org/";
    private final By englishButton = By.xpath("//*[@id='js-link-box-en']/strong");


    public StarterPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }
    public void navigateToWikipedia(){
        webdriver.get(URL);
    }

    public MainPage englishButtonClick(){
        webdriver.findElement(englishButton).click();
        return new MainPage (webdriver);
    }



}
