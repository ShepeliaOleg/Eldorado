import Login_Logout.AuthorizationRegister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by New on 09.07.2014.
 */
public class TestClass {
    AuthorizationRegister autho = new AuthorizationRegister();
    WebDriver driver;
    String url = "http://10.96.32.98:9001/eldoradostorefront/A100/en/";
    private String personalCabinetEN = "Personal cabinet";

    @Before
    public void setUpBeforeClass() throws Exception{
        driver = new FirefoxDriver();
        driver.get(url);

        Thread.sleep(3000);


    }

    @After
    public void tearDown() throws Exception {
        /*autho.logOut(driver, personalCabinetEN);
        driver.quit();*/
    }

    @Test
    public void testOne () throws InterruptedException, IOException {

        /*Exception ex = new Exception();
        System.out.println(ex.getStackTrace()[0].getMethodName());
        String methodName = ex.getStackTrace()[0].getMethodName();*/

        autho.authorization(driver, "sdddddf@gmai.com", "df333333");
        Thread.sleep(5000);
       boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();

        assertTrue(loginException);
        autho.doScreenchot(driver);


    }
}
