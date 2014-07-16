import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.07.2014.
 */
public class Register {

    private WebDriver driver;

    public void register (WebDriver driver, String emailLog, String firstName, String lastName, String password) {

        WebElement reg = driver.findElement(By.xpath("//*[contains(@class, 'headerLogin headerRegister')]"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement name = driver.findElement(By.name("firstName"));
        WebElement suName = driver.findElement(By.name("lastName"));
        WebElement pwd = driver.findElement(By.name("pwd"));
        WebElement registration = driver.findElement(By.xpath("//*[contains(@class, 'regInputSubmit regInputSubmitDisabled')]"));

        reg.click();
        email.sendKeys(Keys.chord(Keys.CONTROL, "a"), emailLog);
        name.sendKeys(Keys.chord(Keys.CONTROL, "a"), firstName);
        suName.sendKeys(Keys.chord(Keys.CONTROL, "a"), lastName);
        pwd.sendKeys(Keys.chord(Keys.CONTROL, "a"), password); registration.click();
        registration.click();
        registration.click();

    }
}
