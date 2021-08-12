package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PrivacyAndPolicyPage {

    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By PRIVACYANDPOLICYBUTTON = By.id("footer-places-privacy");
    private final By PRIVACYANDPOLICYLINKSBUTTON = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/ul/li");
    private final By POLICY_HEADING = By.xpath("//*[@id='firstHeading']");
    private final By REVISION_INFO = By.xpath("//*[@id=\"mw-revision-info\"]");

    private final WebDriver webdriver;

    public PrivacyAndPolicyPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }

    public void navigateToPrivacyPolicy() {

        webdriver.get(URL);
    }


    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("window.scrollBy(0, 14000)");
    }

    public List<String> clickOnPrivacyAndPolicyArchived() {

        List<WebElement> elements = webdriver.findElements(PRIVACYANDPOLICYLINKSBUTTON);

        String linkTexts = "";
        WebDriverWait wait = new WebDriverWait(webdriver, 5);
        List<String> urls = new ArrayList<String>();


        for (WebElement item : elements) {
            WebElement element = item.findElement(By.xpath(".//a"));
            String url = element.getAttribute("href");
            urls.add(url);
        }
        List<String> controlWords = new ArrayList<String>();

        for (String url : urls) {
            webdriver.navigate().to(url);
            linkTexts = webdriver.findElement(REVISION_INFO).getText();
            String[] splitted = linkTexts.split(" ");
            String data = splitted[4] + " "  + splitted[5] + " " + splitted[6];
            controlWords.add(data);
            webdriver.navigate().back();

        }
            return controlWords;

    }



    }
