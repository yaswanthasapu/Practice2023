package testExecution;

import basePage.BaseFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFiles.HomePage;
import pageFiles.ItemPage;

import java.time.Duration;

public class TestExecution extends BaseFile
{
    HomePage homePage;
    ItemPage itemPage;

    @BeforeClass
    public void initializePages(){
        homePage=new HomePage(driver);
        itemPage = new ItemPage(driver);
    }
    @Test
    public void clickItem() throws InterruptedException {
        homePage.searchItemThenClick("Shoes");
        itemPage.clickShoe();
        driver.getWindowHandles().forEach(tab-> driver.switchTo().window(tab));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        itemPage.selectSize("9");
        itemPage.clickAddToCart();
        itemPage.viewCart();
Thread.sleep(1000);
        String text=driver.findElement(By.xpath("//div[@class='col-xs-2 unit-price-block ']")).getText();
        System.out.println("Price of the product: "+text);

        String text1=driver.findElement(By.xpath("//div[@class='cart-collapsed']")).getText();
        System.out.println("Total amount: "+text1);

        Assert.assertTrue(text.contains(text1));



    }
}
