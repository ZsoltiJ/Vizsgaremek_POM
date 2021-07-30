package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

       protected WebDriver webdriver;


        public WebDriver getDriver() {

            return webdriver;
        }

        @BeforeEach
        public void InitialTest() {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            this.webdriver = new ChromeDriver(options);
            webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            webdriver.manage().window().maximize();
        }


        @AfterEach
        public void tearDown() {

            webdriver.quit();
        }

}

