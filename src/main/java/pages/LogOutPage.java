package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {

    WebDriver webdriver;


    private final By LOGINBUTTONCONTROL = By.xpath("//*[@id='pt-login']/a");


    public LogOutPage(WebDriver webdriver) {

        this.webdriver = webdriver;
    }

    public String loggingOut(){

        String actual = webdriver.findElement(LOGINBUTTONCONTROL).getText();
        return actual;


    }



}
