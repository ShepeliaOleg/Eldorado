import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class AuthorizationTest {

	Login_Logout.Authorization autho = new Login_Logout.Authorization();
	private WebDriver driver;
    private String url = "http://10.96.32.98:9001/eldoradostorefront/A100/en";

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
        
	}

	@Test //Корректный Email + корректный пароль
	public void loginWithCorrectEmailPassword() throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, emailCorrect, passwordForEmailCorrect);
        autho.checkCorrectResult(driver, methodName);

	}
    @Test //Корректный номер бонусной карты + корректный PinCorrect-код
    public void loginWithCorrectBCardPin () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, bonusCardCorrect, PinCorrect);
        autho.checkCorrectResult(driver, methodName);

    }
    @Test //Корректный логин + корректный пароль
    public void loginWithCorrectLoginPassword () throws InterruptedException, IOException {
        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, loginCorrect, passwordForLoginCorrect);
        autho.checkCorrectResult(driver, methodName);


    }

    @Test //Корректный логин + некорректный пароль
    public void loginWithCorrectLogAndIncorrectPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, loginCorrect, passwordIncorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Корректный номер бонусной карты + некорректный PinCorrect-код
    public void loginWithCorrectBCardAndIncorrectPin () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, bonusCardCorrect, PinIncorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Корректный Email + некорректный пароль
    public void loginWithCorrectEmailAndIncorrectPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, emailCorrect, passwordIncorrect);
        autho.checkIncorrectResult(driver, methodName);

    }

    @Test //Некорректный логин + корректный пароль
    public void loginWithIncorrectLogAndCorrectPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, loginIncorrect, passwordForLoginCorrect);
        autho.checkIncorrectResult(driver, methodName);

    }

    @Test //Некорректный номер бонусной карты + корректный PinCorrect-код
    public void loginWithIncorrectBCardAndCorrectPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, bonusCardIncorrect, PinCorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Некорректный Email + корректный пароль
    public void loginWithIncorrectEmailAndCorrectPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, emailIncorrect, passwordForEmailCorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Некорректный логин + некорректный пароль
    public void loginWithIncorrectLogPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, loginIncorrect, passwordIncorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Некорректный номер бонусной карты + некорректный PinCorrect-код
    public void loginWithIncorrectBCardPin () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, bonusCardIncorrect, PinIncorrect);
        autho.checkIncorrectResult(driver, methodName);
    }

    @Test //Некорректный Email + некорректный пароль
    public void loginWithIncorrectEmailPassword () throws InterruptedException, IOException {

        Exception ex = new Exception();
        String methodName = ex.getStackTrace()[0].getMethodName().toString();

        autho.authorization(driver, emailIncorrect, passwordIncorrect);
        autho.checkIncorrectResult(driver, methodName);
    }
}
