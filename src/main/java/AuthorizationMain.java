import java.io.IOException;
import java.lang.String;


import org.junit.Assert;
//import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.*;


public class AuthorizationMain {


	private WebDriver driver;
    MakeScreenshot screenshot = new MakeScreenshot();
    private String personalCabinetEN = "Personal cabinet";
    private String personalCabinetRU = "Личный кабинет";

	
	/**
	 * @param driver
	 * @param log
	 * @param password
	 * @throws InterruptedException
	 */
	public void authorization (WebDriver driver, String log, String password) throws InterruptedException{

        WebElement headerLogin = driver.findElement(By.xpath("//*[contains(@id, 'headerLogin')]"));
        headerLogin.click();

        WebElement email_log = driver.findElement(By.xpath("//*[contains(@id, 'USER_LOGIN')]"));
        email_log.sendKeys(Keys.chord(Keys.CONTROL, "a"), log);

        WebElement psd = driver.findElement(By.xpath("//*[contains(@class, 'authPassword')][contains(@type, 'password')]"));
        psd.sendKeys(Keys.chord(Keys.CONTROL, "a"), password);

        WebElement login = driver.findElement(By.xpath("//*[contains(@class, 'authSubmit')]"));
        Thread.sleep(2000);
        login.click();
        Thread.sleep(3000);
    }

    public void checkIncorrectResult (WebDriver driver, String fileName) throws IOException {

        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();

        if (loginException == false){
            screenshot.doScreenchot(driver, fileName);
            System.out.println("Test " + fileName + " is fail");
            Assert.assertTrue(loginException);
        } if (loginException == true){
            System.out.println("Test " + fileName + " is pass");
            Assert.assertTrue(loginException);
        } else {
            screenshot.doScreenchot(driver, fileName);
            System.out.println("Test " + fileName + " is fail");
            Assert.assertTrue(false);
        }
    }

    public void checkCorrectResult (WebDriver driver, String fileName) throws IOException {

        boolean personalCabinetRuLang = driver.getPageSource().contains(personalCabinetRU);
        boolean personalCabinetEnLang = driver.getPageSource().contains(personalCabinetEN);
        /*if (personalCabinet == false){
            screenshot.doScreenchot(driver);
            Assert.assertTrue(personalCabinet);
        } if (personalCabinet == true) {
            Assert.assertTrue(personalCabinet);
        } else {
            screenshot.doScreenchot(driver);
            Assert.assertTrue(personalCabinet);
        }*/

        if (personalCabinetEnLang == true || personalCabinetRuLang == true){
            System.out.println("Test " + fileName + " is pass");
            Assert.assertTrue(true);
        } else {
            screenshot.doScreenchot(driver, fileName);
            System.out.println("Test " + fileName + " is fail");
            Assert.assertTrue(false);
        }
    }

    public void checkForgotPW (WebDriver driver){

        WebElement headerLogin = driver.findElement(By.xpath("//*[contains(@id, 'headerLogin')]"));
        headerLogin.click();

        WebElement forgotPW = driver.findElement(By.xpath("//*[contains(@class, 'authChangePassword')]"));
        forgotPW.click();
    }




}
