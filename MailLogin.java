package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by npoberezhna on 3/14/2017.
 */
public class MailLogin extends TestBase {
    @Test
    public void loginCheck() throws Exception {

        openPage(baseUrl);
        login("goncharenko_nyura@mail.ua", "12345qwert");
        assert(isDisplayCheck());










    }


}
