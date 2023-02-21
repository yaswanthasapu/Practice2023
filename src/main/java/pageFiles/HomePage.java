package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
     WebDriver driver;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    @FindBy( id = "inputValEnter")
    WebElement serachbar;

    @FindBy (xpath = "//span[@ class='searchTextSpan']")
    WebElement searchbutton;

    public void searchItemThenClick(String str){
        serachbar.sendKeys(str);
        searchbutton.click();
    }
}
