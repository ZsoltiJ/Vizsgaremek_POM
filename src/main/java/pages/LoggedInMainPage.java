package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class LoggedInMainPage {


    private final WebDriver webdriver;

    private final By SEARCHFIELD = By.xpath("//*[@id='searchInput']");
    private final By SEARCHBUTTON = By.xpath("//*[@id='searchButton']");
    private final By SANDBOXBUTTON = By.xpath("//*[@id='pt-sandbox']/a");
    private final By LOGOUTBUTTON = By.xpath("//*[@id='pt-logout']/a");
    private final By HEADERTEXT = By.xpath("//*[@id='On_this_day']");
    private final By SAVETOFILETEXT = By.xpath("//*[@id='mp-otd']");





    public LoggedInMainPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }

    public void navigateUrl(){

        String URL = "https://en.wikipedia.org/wiki/Main_Page";
        webdriver.get(URL);
    }
    public FerrariPage sendSearchWord(String nameOfCar){
        webdriver.findElement(SEARCHFIELD).sendKeys(nameOfCar);
        webdriver.findElement(SEARCHBUTTON).click();
        return new FerrariPage(webdriver);

    }

    public SearchResultPage morePagesLists(){
        webdriver.findElement(SEARCHFIELD).sendKeys();
        webdriver.findElement(SEARCHBUTTON ).click();
        return new SearchResultPage(webdriver);
    }

    public SandBoxPage newDataTyping(){
        webdriver.findElement(SANDBOXBUTTON).click();
        return new SandBoxPage(webdriver);
    }

    public void dataModifing(){


        String[] array = {"Ferrari", "Mercedes", "BMW", "Audi", "Renault"};


        for (int i = 0; i < 5; i++) {

            webdriver.findElement(SEARCHFIELD).click();
            webdriver.findElement(SEARCHFIELD).sendKeys(array[i]);
            webdriver.findElement(SEARCHBUTTON).click();
            webdriver.findElement(SEARCHFIELD).clear();
        }
    }

    public LogOutPage logOut(){
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


}