package Login_Logout;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShowQuestionnaire {
	
	private WebDriver driver;
	
	public void lastName (WebDriver driver, String lastName){
		WebElement suName = driver.findElement(By.id("questionnaire.lastName"));
		suName.sendKeys(Keys.chord(Keys.CONTROL, "a"), lastName);
	}
	
	public void firstName (WebDriver driver, String firstName){
		WebElement name = driver.findElement(By.id("questionnaire.firstName"));
		name.sendKeys(Keys.chord(Keys.CONTROL, "a"), firstName);
	}
	
	public void email (WebDriver driver, String e_Mail){
		WebElement email = driver.findElement(By.id("questionnaire.email"));
		email.sendKeys(Keys.chord(Keys.CONTROL, "a"), e_Mail);
	}

	public void numberPhone (WebDriver driver, int code, int number){
		String codeStr = Integer.toString(code);
		String numberStr = Integer.toString(number);
		
		WebElement mobile_code = driver.findElement(By.id("mobile.code"));
		WebElement mobile_number = driver.findElement(By.id("mobile.number"));
		
		mobile_code.sendKeys(Keys.chord(Keys.CONTROL, "a"), codeStr);
		mobile_number.sendKeys(Keys.chord(Keys.CONTROL, "a"), numberStr);
	}

	public void region (WebDriver driver, String region){
		
		WebElement questionnaire_region = driver.findElement(By.id("questionnaire.region"));
		questionnaire_region.sendKeys(Keys.chord(Keys.CONTROL, "a"), region);
	}
	
	public void city (WebDriver driver, String city) {
		
		WebElement questionnaire_city = driver.findElement(By.id("questionnaire.city"));
		questionnaire_city.sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
	}
	
	public void street (WebDriver driver, String street) {
		
		WebElement questionnaire_street = driver.findElement(By.id("questionnaire.street"));
		questionnaire_street.sendKeys(Keys.chord(Keys.CONTROL, "a"), street);
	}
}
