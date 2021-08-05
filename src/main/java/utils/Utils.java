package utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public String[] readOuterData() throws FileNotFoundException {
        String[] result = new String[6];
        try {
            File myOuterFile = new File("outerDataSending.txt");
            Scanner scanner = new Scanner(myOuterFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temporaryFile = data.split(" = ");
                if (temporaryFile[0].equals("first")) {
                    result[0] = temporaryFile[1];
                } else if (temporaryFile[0].equals("second")) {
                    result[1] = temporaryFile[1];
                } else if (temporaryFile[0].equals("third")) {
                    result[2] = temporaryFile[1];
                } else if (temporaryFile[0].equals("fourth")) {
                    result[3] = temporaryFile[1];
                } else if (temporaryFile[0].equals("fifth")) {
                    result[4] = temporaryFile[1];
                } else if (temporaryFile[0].equals("sixth")){
                    result[5] = temporaryFile[1];
                }


            }


            scanner.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        return result;
    }

}
