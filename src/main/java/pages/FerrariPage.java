package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FerrariPage {

    WebDriver webdriver;

    private final String URL = "https://en.wikipedia.org/wiki";
    //private final By INPUTFIELD = By.xpath("//*[@id='searchInput']");
    //private final By CLICKONFINDBUTTON = By.xpath("//*[@id='searchButton']");
    private final By FINDELEMENT = By.xpath("//*");



    public FerrariPage(WebDriver webdriver) {
        this.webdriver = webdriver;

    }

    public void navFerrari() {

        webdriver.get(URL);
    }

   /* public void sendKeyWord(String word){

    webdriver.findElement(INPUTFIELD).sendKeys(word);
    } */


   /* public void clickOnSearch() {
        webdriver.findElement(CLICKONFINDBUTTON).click();

    } */

    public boolean searchCarName(String carName) {

        boolean isSearchCarName = false;
        int number = 0;

        List<WebElement> words = webdriver.findElements(FINDELEMENT);

        for (WebElement elements : words) {

            try {
                if (elements.getText().contains(carName)) {
                    number += 1;
                    isSearchCarName = true;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }


        }
             System.out.println("'Ferrari' is founded: " + number + " pieces.");
             return  isSearchCarName;
        }


}
