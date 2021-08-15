package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FerrariPage {

    WebDriver webdriver;

    private final String URL = "https://en.wikipedia.org/wiki";
    private final By FINDELEMENT = By.xpath("//*");


    public FerrariPage(WebDriver webdriver) {
        this.webdriver = webdriver;

    }

    public void navFerrari() {

        webdriver.get(URL);
    }


    public int searchCarName(String carName) {


        int number = 0;

        List<WebElement> words = webdriver.findElements(FINDELEMENT);

        for (WebElement elements : words) {

            try {
                if (elements.getText().contains(carName)) {
                    number += 1;


                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }


        }
        System.out.println("'Ferrari' is founded: " + number + " pieces.");
        return number;
    }


}
