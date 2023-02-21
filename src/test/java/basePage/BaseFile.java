package basePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseFile {
   public WebDriver driver;
   @BeforeSuite
   public void openBrowser(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

   }
   @BeforeTest
    public void launchPage()  {
       driver.get("https://www.snapdeal.com/");

   }
}
