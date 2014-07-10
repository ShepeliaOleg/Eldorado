package Login_Logout;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by New on 09.07.2014.
 */
public class MakeScreenshot {

    private WebDriver driver;
    Exception ex = new Exception();


    public void doScreenchot (WebDriver driver, String fileName) throws IOException {


        String methodName = ex.getStackTrace()[0].getMethodName();

        String path = "c:\\temp\\"+fileName+"_screenshot.png";
        //String path = "c:\\temp\\screenshot.png";

        File sreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(sreenshot, new File(path));


    }

    public void returnMethodName (){
        boolean a = false;
        boolean b = true;
        if (true == a || true == a){
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }
}
