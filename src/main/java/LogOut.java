import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by New on 09.07.2014.
 */
public class LogOut {

    private WebDriver driver;

    public void logOut (WebDriver driver, String langPersonalCabinet) throws InterruptedException{

        Actions actions = new Actions(driver);
        WebElement PersonalCabinet = driver.findElement(By.xpath("//*[contains(text(), '" + langPersonalCabinet + "')]"));
        actions.moveToElement(PersonalCabinet).build().perform();
        Thread.sleep(5000);

        WebElement logOut = driver.findElement(By.xpath("//*[contains(text(), 'Sign Out')]"));
        logOut.click();

    }

}
