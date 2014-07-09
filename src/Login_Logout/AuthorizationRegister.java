package Login_Logout;

import java.io.File;
import java.io.IOException;
import java.lang.String;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class AuthorizationRegister {

	private WebDriver driver;
	
	/**
	 * @param driver
	 * @param log
	 * @param password
	 * @throws InterruptedException
	 */
	public void authorization (WebDriver driver, String log, String password) throws InterruptedException{ WebElement headerLogin = driver.findElement(By.xpath("//*[contains(@id, 'headerLogin')]")); headerLogin.click(); WebElement email_log = driver.findElement(By.xpath("//*[contains(@id, 'USER_LOGIN')]")); email_log.sendKeys(Keys.chord(Keys.CONTROL, "a"), log); WebElement psd = driver.findElement(By.xpath("//*[contains(@class, 'authPassword')][contains(@type, 'password')]")); psd.sendKeys(Keys.chord(Keys.CONTROL, "a"), password); WebElement login = driver.findElement(By.xpath("//*[contains(@class, 'authSubmit')]")); Thread.sleep(2000); login.click(); } public void register (WebDriver driver, String emailLog, String firstName, String lastName, String password) { WebElement reg = driver.findElement(By.xpath("//*[contains(@class, 'headerLogin headerRegister')]")); WebElement email = driver.findElement(By.name("email")); WebElement name = driver.findElement(By.name("firstName")); WebElement suName = driver.findElement(By.name("lastName")); WebElement pwd = driver.findElement(By.name("pwd")); WebElement registration = driver.findElement(By.xpath("//*[contains(@class, 'regInputSubmit regInputSubmitDisabled')]")); reg.click(); email.sendKeys(Keys.chord(Keys.CONTROL, "a"), emailLog); name.sendKeys(Keys.chord(Keys.CONTROL, "a"), firstName); suName.sendKeys(Keys.chord(Keys.CONTROL, "a"), lastName); pwd.sendKeys(Keys.chord(Keys.CONTROL, "a"), password); registration.click(); registration.click(); registration.click();
	}

	public void logOut (WebDriver driver, String langPersonalCabinet) throws InterruptedException{
		 
		
		Actions actions = new Actions(driver);
		WebElement PersonalCabinet = driver.findElement(By.xpath("//*[contains(text(), '"+langPersonalCabinet+"')]"));
		actions.moveToElement(PersonalCabinet).build().perform();
		Thread.sleep(5000);
		
		WebElement logOut = driver.findElement(By.xpath("//*[contains(text(), 'Sign Out')]"));
		logOut.click();
		
	}

    public void chooseERegionStartEnter (WebDriver driver, Enum ERegion, String eRegion){


        if (ERegion.equals("Yes")){

            WebElement rightRegion = driver.findElement(By.xpath("//*[contains(@id, 'rightRegion')]"));
            rightRegion.click();

        } if (ERegion.equals("No")) {

            WebElement wrongRegion = driver.findElement(By.xpath("//*[contains(@id, 'wrongRegion')]"));
            wrongRegion.click();

            WebElement newRegion = driver.findElement(By.xpath("//*[contains(@class, 'regionCity')][contains(text(), '" + eRegion + "')]"));
            newRegion.click();
        }
    }

    public void chooseERion (WebDriver driver, String eRegion){

        WebElement currentRegion = driver.findElement(By.xpath("//*[contains(@class, 'headerRegionName')]"));
        currentRegion.click();
        WebElement region = driver.findElement(By.xpath("//*[contains(@class, 'regionCity')][contains(text(), '"+eRegion+"')]"));
        region.click();
    }

    public void doScreenchot (WebDriver driver, String path) throws IOException {

        File sreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(sreenshot, new File(path));
    }
}
