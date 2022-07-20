import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {

    @Test
    public void windowHandleTest (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/windows");

        String firstWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        Set <String> windowsHandleSet = driver.getWindowHandles();

        for (String each : windowsHandleSet){
            if (!each.equals(firstWindow)){
                driver.switchTo().window(each);

                String actualWindowsText = driver.findElement(By.xpath("//h3[.='New Window']")).getText();

                Assert.assertEquals("Test failed", "New Window", actualWindowsText);
                break;
            }
        }
        driver.quit();
    }
}