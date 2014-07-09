import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.sun.javafx.scene.EnteredExitedHandler;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Login_Logout.AuthorizationRegister;

import java.io.IOException;


public class Authorization {

	AuthorizationRegister autho = new AuthorizationRegister();
	private WebDriver driver;
    private String url = "http://10.96.32.98:9001/eldoradostorefront/A100/en";
    private String personalCabinetEN = "Personal cabinet";
    private String personalCabinetRU = "Личный кабинет";

    // login with Email
    private String emailCorrect = "oleg25@gmail.com";
    private String passwordForEmailCorrect = "111111";
    private String emailIncorrect = "oleg2345435@gmail.com";
    private String passwordIncorrect = "sdfsdfssdfs";

    // login with Log
    private String loginCorrect = "sdfsd";
    private String passwordForLoginCorrect = "sdfsfe34r";
    private String loginIncorrect = "dfgdfg";

    // login with bonus card + Pin-code
    private String bonusCardCorrect = "9643781000004860";
    private String PinCorrect = "2222";
    private String bonusCardIncorrect = "9643781000004890";
    private String PinIncorrect = "1111";


    @Before
	public void setUpBeforeClass() throws Exception{
	driver = new FirefoxDriver ();
	driver.get(url);

	Thread.sleep(3000);

	
	}

	@After
	public void tearDown() throws Exception {
      // autho.logOut(driver, personalCabinetEN);
        driver.quit();
	}

	@Test //Корректный Email + корректный пароль
	public void loginWithCorrectEmailPassword() throws InterruptedException, IOException {

        autho.authorization(driver, emailCorrect, passwordForEmailCorrect);
		Thread.sleep(3000);
        boolean personalCabinet = driver.getPageSource().contains(personalCabinetEN);
        assertTrue(personalCabinet);


	}
    @Test //Корректный номер бонусной карты + корректный PinCorrect-код
    public void loginWithCorrectBCardPin () throws InterruptedException{

        autho.authorization(driver, bonusCardCorrect, PinCorrect);
        Thread.sleep(3000);
        boolean personalCabinet = driver.getPageSource().contains(personalCabinetEN);
        assertTrue(personalCabinet);

    }
    @Test //Корректный логин + корректный пароль
    public void loginWithCorrectLoginPassword () throws InterruptedException {

        autho.authorization(driver, loginCorrect, passwordForLoginCorrect);
        Thread.sleep(3000);
        boolean personalCabinet = driver.getPageSource().contains(personalCabinetEN);
        assertTrue(personalCabinet);

    }

    @Test //Корректный логин + некорректный пароль
    public void loginWithCorrectLogAndIncorrectPassword ()throws InterruptedException{

        autho.authorization(driver, loginCorrect, passwordIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        //assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed());
        assertTrue(loginException);
    }

    @Test //Корректный номер бонусной карты + некорректный PinCorrect-код
    public void loginWithCorrectBCardAndIncorrectPin () throws InterruptedException {

        autho.authorization(driver, bonusCardCorrect, PinIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);
    }

    @Test //Корректный Email + некорректный пароль
    public void loginWithCorrectEmailAndIncorrectPassword () throws InterruptedException {

        autho.authorization(driver, emailCorrect, passwordIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный логин + корректный пароль
    public void loginWithIncorrectLogAndCorrectPassword () throws InterruptedException {

        autho.authorization(driver, loginIncorrect, passwordForLoginCorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный номер бонусной карты + корректный PinCorrect-код
    public void loginWithIncorrectBCardAndCorrectPassword () throws InterruptedException {

        autho.authorization(driver, bonusCardIncorrect, PinCorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный Email + корректный пароль
    public void loginWithIncorrectEmailAndCorrectPassword () throws InterruptedException {

        autho.authorization(driver, emailIncorrect, passwordForEmailCorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный логин + некорректный пароль
    public void loginWithIncorrectLogPassword () throws InterruptedException {

        autho.authorization(driver, loginIncorrect, passwordIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный номер бонусной карты + некорректный PinCorrect-код
    public void loginWithIncorrectBCardPin () throws InterruptedException {

        autho.authorization(driver, bonusCardIncorrect, PinIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }

    @Test //Некорректный Email + некорректный пароль
    public void loginWithIncorrectEmailPassword () throws InterruptedException {

        autho.authorization(driver, emailIncorrect, passwordIncorrect);
        Thread.sleep(3000);
        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();
        assertTrue(loginException);

    }
}
