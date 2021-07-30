package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {


    private WebDriver webdriver;

    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By WIKITEST = By.id("mp-welcome");
    private final By LOGINBUTTON = By.xpath("//*[@id='pt-login']/a");
    private final By USERNAMEINPUT = By.xpath("//*[@id='wpName1']");
    private final By PASSWORDINPUT = By.xpath("//*[@id='wpPassword1']");
    private final By CLICKBLUELOGINBUTTON = By.xpath("//*[@id='wpLoginAttempt']");
    private final By PRIVACYANDPOLICYBUTTON = By.xpath("//*[@id='footer-places-privacy']/a");


    public MainPage(WebDriver webdriver){

        this.webdriver = webdriver;

    }
    public void navigateToLogin(){
        webdriver.get(URL);
    }
    public String getWikiText(){
         String text =  webdriver.findElement(WIKITEST).getText();
         return text;
    }

    public void clickLoginButton(){
        webdriver.findElement(LOGINBUTTON).click();

    }

    public void sendUsername(String username){
        webdriver.findElement(USERNAMEINPUT).sendKeys(username);
    }

    public void sendPassword(String password){
        webdriver.findElement(PASSWORDINPUT).sendKeys(password);
    }

    public LoggedInMainPage clickBlueLoginButton(){
        webdriver.findElement(CLICKBLUELOGINBUTTON).click();
        return new LoggedInMainPage(webdriver);
    }

    public PrivacyAndPolicyPage clickOnPrivacyAndPolicyButton(){
        webdriver.findElement(PRIVACYANDPOLICYBUTTON).click();
            return new PrivacyAndPolicyPage(webdriver);


    }


}
