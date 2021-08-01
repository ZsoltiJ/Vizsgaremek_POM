package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    WebDriver webdriver;

    public Utils(WebDriver webdriver) {

        this.webdriver = webdriver;
    }

    public void writeToFile(String path1, String path2) {
        try {
            FileWriter textFile = new FileWriter("searchResults.txt");

            textFile.append(path1).append(" : \n").append(path2);

            textFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
