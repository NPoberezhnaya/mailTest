package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by npoberezhna on 3/14/2017.
 */
public class TestBase {
    protected WebDriver driver;
    protected String baseUrl;
    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C://FFF//geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://mail.ru/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void openPage(String path) {
        driver.get(path);
    }

    protected void login(String log, String password) {
        String loginNameXpath = "Login";
        String passNameXpath = "Password";
        String clickButtonName = "mailbox__auth__button";

        driver.findElement(By.name(loginNameXpath)).clear();
        driver.findElement(By.name(loginNameXpath)).sendKeys(log);

        driver.findElement(By.name(passNameXpath)).clear();
        driver.findElement(By.name(passNameXpath)).sendKeys(password);


        driver.findElement(By.className(clickButtonName)).click();

    }

    protected void  waitUntil()
    {
        // wait until "Входящие" appears
        String inputLabelXPath = ".//*[@id='b-nav_folders']//span[contains(@class, \"b-nav__item__text b-nav__item__text_unread\")]";
        WebDriverWait wait = new WebDriverWait(driver, 30/*seconds*/);
        WebElement element = wait.until(presenceOfElementLocated(By.xpath(inputLabelXPath)));


    }


    protected Boolean  isDisplayCheck() {
        waitUntil();
        String inputLabelXPath = ".//*[@id='b-nav_folders']//span[contains(@class, \"b-nav__item__text b-nav__item__text_unread\")]";
        Boolean bool = driver.findElement(By.xpath(inputLabelXPath)).isDisplayed();
        // System.out.println(bool);
        return bool;
    }
}
