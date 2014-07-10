import Login_Logout.*;
import Login_Logout.Authorization;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestShowQuestionnaire {

	ShowQuestionnaire showQuestionnaire = new ShowQuestionnaire();
	Authorization authorizationRegister = new Login_Logout.Authorization();
	
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
