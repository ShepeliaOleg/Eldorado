package Login_Logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by New on 09.07.2014.
 */
public class ChooseRegion {

    private WebDriver driver;

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

    public void chooseERegion(WebDriver driver, String eRegion){

        WebElement currentRegion = driver.findElement(By.xpath("//*[contains(@class, 'headerRegionName')]"));
        currentRegion.click();
        WebElement region = driver.findElement(By.xpath("//*[contains(@class, 'regionCity')][contains(text(), '"+eRegion+"')]"));
        region.click();
    }
}
