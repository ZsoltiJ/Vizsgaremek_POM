package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {

    private WebDriver webdriver;

    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By FIRST500BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[6]");
    private final By NEXT500BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By MORE500BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[2]");
    private final By FINDLINKS = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li");
    private final By FINDEVERYLINKS = By.xpath(".//a");


    public SearchResultPage(WebDriver webdriver) {
        this.webdriver = webdriver;

    }



    public void clickOnFirst500Button()
    {

        webdriver.findElement(FIRST500BUTTON).click();
    }

    public void clickOnNext500Button(){

        webdriver.findElement(NEXT500BUTTON).click();
    }

    public void morePagesLists() {


        List<WebElement> links;


        WebDriverWait wait = new WebDriverWait(webdriver, 5);


        int l = 0;
        while( webdriver.findElement(MORE500BUTTON).isDisplayed() && l <= 2 ) {
            l++;
            links = webdriver.findElements(FINDLINKS);
            for (int j = 0; j < links.size(); j++) {

                WebElement link = links.get(j).findElement(FINDEVERYLINKS);
                System.out.println(link.getText());

            }
             //System.out.println(l);
            try {

                wait.until(ExpectedConditions.visibilityOfElementLocated(MORE500BUTTON));

                webdriver.findElement(MORE500BUTTON).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();

            }

        }
    }


}
