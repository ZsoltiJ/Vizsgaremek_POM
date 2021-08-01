package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPage {


    WebDriver webdriver;


    private final By SANDBOXBUTTON = By.xpath("//*[@id=\"pt-sandbox\"]/a");
    private final By CLICKONINPUTFIELD = By.xpath("//*[@id='wpTextbox1']");
    private final By PREVIEWBUTTON = By.xpath("//*[@id='wpPreview']");


    public SandBoxPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }


    public void clickOnSandboxButton() {

        webdriver.findElement(SANDBOXBUTTON).click();
    }

    public void inputField(String text) {
        webdriver.findElement(CLICKONINPUTFIELD).sendKeys(text);

    }


    public String repeatedDataSending(String s) throws InterruptedException {

        webdriver.findElement(SANDBOXBUTTON).click();
        webdriver.findElement(CLICKONINPUTFIELD).click();

        String data = "";
        for (int i = 0; i <= 5; i++) {
            try {
                File myFile = new File("PoetsAndAuthors.txt");
                Scanner scanner = new Scanner(myFile);
                while (scanner.hasNextLine()) {
                    data = scanner.nextLine();
                    webdriver.findElement(CLICKONINPUTFIELD).sendKeys(data);

                }
                    scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        webdriver.findElement(PREVIEWBUTTON).click();

        return data;
    }

    public void deleteData() {

        String URL = "https://en.wikipedia.org/w/index.php?title=User:Szuperteszter/sandbox&action=edit&redlink=1&preload=Template%3AUser+sandbox%2Fpreload";
        webdriver.get(URL);
        webdriver.findElement(SANDBOXBUTTON).click();
        webdriver.findElement(CLICKONINPUTFIELD).click();
        webdriver.findElement(CLICKONINPUTFIELD).sendKeys("My birthday will in march 2020. \n Please delete me, because I'm an old message");
        webdriver.findElement(CLICKONINPUTFIELD).clear();

    }

}





