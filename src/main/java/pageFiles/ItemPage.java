package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
     private WebDriver driver;



    public  ItemPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[contains(@class,'product-tuple-image ')]")
    WebElement shoe;

    @FindBy(xpath = "//span[text()='add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//div[text()='View Cart']")
    WebElement viewCart;


    public void clickShoe(){
        shoe.click();
        //System.out.println(size.getText());
    }

    public void selectSize(String size){
        driver.findElement(By.xpath("//div[@selectedattr='"+size+"']/div")).click();
    }

    public void clickAddToCart(){
        Actions s1 = new Actions(driver);
        s1.click(addToCart).build().perform();
    }
    public void viewCart(){
        viewCart.click();
    }




}
