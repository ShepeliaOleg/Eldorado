package Login_Logout;

import java.io.File;
import java.io.IOException;
import java.lang.String;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class Authorization {

	private WebDriver driver;
    MakeScreenshot screenshot = new MakeScreenshot();

	
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
    }

    public void checkIncorrectResult (WebDriver driver) throws IOException {

        boolean loginException = driver.findElement(By.xpath("//*[contains(@class, 'invalid errorBox')]")).isDisplayed();

        if (loginException == false){
            screenshot.doScreenchot(driver);
            Assert.assertTrue(loginException);
        } if (loginException == true){
            Assert.assertTrue(loginException);
        } else {
            screenshot.doScreenchot(driver);
            Assert.assertTrue(false);
        }
    }

    public void checkCorrectResult (WebDriver driver, String personalCabinetLang) throws IOException {

        boolean personalCabinet = driver.getPageSource().contains(personalCabinetLang);
        if (personalCabinet == false){
            System.out.println("1");
            screenshot.doScreenchot(driver);
            Assert.assertTrue(personalCabinet);
        } if (personalCabinet == true) {
            System.out.println("2");
            Assert.assertTrue(personalCabinet);
        } else {
            System.out.println("3");
            screenshot.doScreenchot(driver);
            Assert.assertTrue(personalCabinet);
        }
    }





}
