package Login_Logout;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {

	private WebDriver driver; 
	private String url = "http://abc.eldorado.ru";
	private String Email = "shepelia.oleg@gmail.com";
	private String password = "111111";
	private String NotCorEmail = "not";
	private String NotCorPassword = "11";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}


	@Test
	public void testCorrectData() {

		WebElement log = driver.findElement(By.xpath("//input[contains (@id, 'j_username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'j_password')]"));
		WebElement button_Login = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
		log.sendKeys(this.Email);
		password.sendKeys(this.password);
		button_Login.click();
		
		Assert.assertTrue(driver.getPageSource().contains("Welcome Oleg"));
		
		WebElement SingOut = driver.findElement(By.xpath("//span[contains(@class, 'logged_in')]/a[2]"));
		SingOut.click();
		
	}

	@Test
	public void testNotCorrectEmail(){
		
		WebElement log = driver.findElement(By.xpath("//input[contains (@id, 'j_username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'j_password')]"));
		WebElement button_Login = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
		log.sendKeys(this.NotCorEmail);
		password.sendKeys(this.password);
		button_Login.click();
		
		assertTrue(driver.getPageSource().contains(driver.findElement(By.xpath("//*[contains(@class, 'alert negative')]")).getText()));
		assertTrue(driver.getPageSource().contains("Вход"));
	}
	
	@Test
	public void testNotCorrectPassword (){
		WebElement log = driver.findElement(By.xpath("//input[contains (@id, 'j_username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'j_password')]"));
		WebElement button_Login = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
		log.sendKeys(this.Email);
		password.sendKeys(this.NotCorPassword);
		button_Login.click();
		
		assertTrue(driver.getPageSource().contains(driver.findElement(By.xpath("//*[contains(@class, 'alert negative')]")).getText()));
		assertTrue(driver.getPageSource().contains("Вход"));
	}
	
	@Test
	public void testNotCorrectData() {
		
		WebElement log = driver.findElement(By.xpath("//input[contains (@id, 'j_username')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@id, 'j_password')]"));
		WebElement button_Login = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
		log.sendKeys(this.NotCorEmail);
		password.sendKeys(this.NotCorPassword);
		button_Login.click();
		
		assertTrue(driver.getPageSource().contains(driver.findElement(By.xpath("//*[contains(@class, 'alert negative')]")).getText()));
		assertTrue(driver.getPageSource().contains("Вход"));
	}
	
	@After
	public void tearDown() throws Exception {
	
	driver.quit();
		
	}

}
