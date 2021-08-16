package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoggedInMainPage {


    private final WebDriver webdriver;
    Utils utils;


    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By SEARCHFIELD = By.xpath("//*[@id='searchInput']");
    private final By SEARCHBUTTON = By.xpath("//*[@id='searchButton']");
    private final By LOGOUTBUTTON = By.xpath("//*[@id='pt-logout']/a");
    private final By HEADERTEXT = By.xpath("//*[@id='On_this_day']");
    public final By SPECIALPAGEBUTTON = By.xpath("//*[@id=\"t-specialpages\"]/a");
    public final By INNERSEARCHFIELD = By.xpath("//*[@id=\"ooui-php-1\"]");
    public final By INNERSEARCHBUTTON = By.xpath("//*[@id=\"mw-search-top-table\"]/div/div/div/span/span/button/span[2]");
    public final By SEARCHLIST = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/ul/li");
    public final By BUTTON100 = By.xpath("//*[@id=\"mw-content-text\"]/div[4]/p[2]/a[4]");


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


 /*   public void searchAndSaveToFile() {

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


    } */

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

    public void sendData(String word) {

        webdriver.findElement(INNERSEARCHFIELD).sendKeys(word + " ");
    }



    public void clickOnInnerSearchButton() {

        webdriver.findElement(INNERSEARCHBUTTON).click();
    }

    public boolean items() {


        Actions actions = new Actions(webdriver);
        WebElement button = webdriver.findElement(BUTTON100);
        actions.moveToElement(button);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.click();
        List<WebElement> items = webdriver.findElements(SEARCHLIST);
        boolean isCaptcha = false;
        int counter = 0;
        for (WebElement item : items) {
            counter++;
            if (item.getText().toLowerCase().contains("captcha".toLowerCase())) {
                isCaptcha = true;
            }

        }
        System.out.println("Number of links: " + counter);

        return isCaptcha;


    }

    public String getFirstHeadingText() {
        String expected = webdriver.findElement(By.xpath("//*[@id='firstHeading']")).getText();

        return expected;
    }

    public String searchAndSaveToFile() throws IOException {

        webdriver.get(URL);
        String savedFile = "";
        String actualText = "";
        String message = "";

        // previous saved file
        try {
            File myObj = new File("MainPageSavedText.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                savedFile += data + "\n";

            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        actualText = webdriver.findElement(HEADERTEXT).getText() + "\n";
        actualText += webdriver.findElement(By.xpath("//*[@id='mp-otd']")).getText() + "\n";


        System.out.println(actualText);
        System.out.println(savedFile);

        //Assertions.assertEquals(actualText, savedFile); // control under work.

        if (!actualText.equals(savedFile)) {
            try {
                FileWriter myWriter = new FileWriter("MainPageSavedText.txt");
                myWriter.append(actualText);
                myWriter.close();
                message = "Successfully wrote to the file.";
                System.out.println(message);

            } catch (IOException e) {
                message = "An error occurred.";
                System.out.println(message);
                e.printStackTrace();
            }

        } else {
            message = "This file has not modified.";
            System.out.println(message);

        }
        return message;
    }


    public String fileModifying(String newData) {

        String message = "";

        try {
            FileWriter myWriter = new FileWriter("MainPageSavedText.txt");
            myWriter.append(newData);
            myWriter.close();
            message = "The file has modified.";
            System.out.println(message);

        } catch (IOException e) {
            message = "An error occurred.";
            System.out.println(message);
            e.printStackTrace();
        }

        return message;
    }

}


