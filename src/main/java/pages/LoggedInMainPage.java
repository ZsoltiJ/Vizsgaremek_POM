package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoggedInMainPage {


    private final WebDriver webdriver;
    LoggedInMainPage loggedInMainPage;
    Utils utils;


    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By SEARCHFIELD = By.xpath("//*[@id='searchInput']");
    private final By SEARCHBUTTON = By.xpath("//*[@id='searchButton']");
    private final By SANDBOXBUTTON = By.xpath("//*[@id='pt-sandbox']/a");
    private final By LOGOUTBUTTON = By.xpath("//*[@id='pt-logout']/a");
    private final By HEADERTEXT = By.xpath("//*[@id='On_this_day']");
    private final By SAVETOFILETEXT = By.xpath("//*[@id='mp-otd']");
    public final By SPECIALPAGEBUTTON = By.xpath("//*[@id=\"t-specialpages\"]/a");
    public final By INNERSEARCHFIELD = By.xpath("//*[@id=\"ooui-php-1\"]");
    public final By INNERSEARCHBUTTON = By.xpath("//*[@id=\"mw-search-top-table\"]/div/div/div/span/span/button/span[2]");
    public final By SEARCHLIST = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/ul/li");


    public LoggedInMainPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }

    public void navigateUrl() {

        webdriver.get(URL);

    }

    public FerrariPage sendSearchWord(String car) {
        webdriver.findElement(SEARCHFIELD).sendKeys(car);
        webdriver.findElement(SEARCHBUTTON).click();
        return new FerrariPage(webdriver);

    }

    public SearchResultPage morePagesLists(String searchWords) {
        webdriver.findElement(SEARCHFIELD).sendKeys(searchWords);
        webdriver.findElement(SEARCHBUTTON).click();
        return new SearchResultPage(webdriver);
    }

    public SandBoxPage newDataTyping() {
        webdriver.findElement(SANDBOXBUTTON).click();
        return new SandBoxPage(webdriver);
    }

    public void dataModifing() {


        String[] array = {"Ferrari", "Mercedes", "BMW", "Audi", "Renault"};


        for (int i = 0; i < 5; i++) {

            webdriver.findElement(SEARCHFIELD).click();
            webdriver.findElement(SEARCHFIELD).sendKeys(array[i]);
            webdriver.findElement(SEARCHBUTTON).click();
            webdriver.findElement(SEARCHFIELD).clear();
        }
    }

    public LogOutPage logOut() {
        webdriver.findElement(LOGOUTBUTTON).click();
        return new LogOutPage(webdriver);
    }


    public void searchAndSaveToFile() {

        try {
            FileWriter myWriter = new FileWriter("MainPageSavedText.txt");
            myWriter.append(webdriver.findElement(HEADERTEXT).getText()).append("\n");
            myWriter.append(webdriver.findElement(SAVETOFILETEXT).getText()).append("\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public SpecialPages clickOnSpecPageButton() {
        webdriver.findElement(SPECIALPAGEBUTTON).click();
        return new SpecialPages(webdriver);
    }



    public void clickInSearchFieldButton() {
        webdriver.findElement(SEARCHBUTTON).click();
    }

    public void clickInnerSearchField() {
        webdriver.findElement(INNERSEARCHFIELD).click();

    }


    public void sendData1(String first){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(first + " ");
    }
    public void sendData2(String second){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(second + " ");
    }
    public void sendData3(String third){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(third + " ");
    }
    public void sendData4(String fourth){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(fourth + " ");
    }
    public void sendData5(String fifth){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(fifth + " ");
    }
    public void sendData6(String sixth){
        webdriver.findElement(INNERSEARCHFIELD).sendKeys(sixth);
    }

    public void clickOnInnerSearchButton(){

        webdriver.findElement(INNERSEARCHBUTTON).click();
    }

    public boolean items(){

        List<WebElement> item = webdriver.findElements(SEARCHLIST);
        List<String> result = new ArrayList<>();
        boolean isCaptcha = false;

        for (WebElement items : item) {
           WebElement linkText = webdriver.findElement(SEARCHLIST);
           if (linkText.getText().toLowerCase().contains("captcha".toLowerCase())){

               isCaptcha = true;
        }

        }

        return isCaptcha;


}
}