import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Login_Logout.AuthorizationRegister;
import Login_Logout.ShowQuestionnaire;


public class TestShowQuestionnaire {

	ShowQuestionnaire showQuestionnaire = new ShowQuestionnaire();
	AuthorizationRegister authorizationRegister = new AuthorizationRegister();
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void ConfirmationEmail() throws InterruptedException {
		
		driver = new ChromeDriver ();
		driver.get("");
		driver.manage().window().maximize();
		authorizationRegister.authorization(driver, "", "");
	}

}
