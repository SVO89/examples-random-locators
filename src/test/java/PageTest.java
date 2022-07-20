import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest {

    @Test
    public void popupTest (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


        driver.quit();

    }
}
