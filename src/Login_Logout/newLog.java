package Login_Logout;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class newLog {
	private WebDriver driver;
	private String url = "http://192.168.0.18:9001/eldoradostorefront/A100/ru/";

	AuthorizationRegister authorizationRegister = new AuthorizationRegister();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	
	@Test
	public void test () throws Exception{
		
		authorizationRegister.register(driver, "fss@mail.ru", "firstName", "lastName", "111111");
		
	}
	
}
