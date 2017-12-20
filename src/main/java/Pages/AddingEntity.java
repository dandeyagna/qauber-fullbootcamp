package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class AddingEntity {
    public AddingEntity(WebDriver driver){
       PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@class='ng-binding']")
    private List<WebElement> selectEntity1;
   // @FindBy(xpath = "//label[text()='cubo@nada.ltd']/span")
    //WebElement selectingEntity;
    @FindBy(xpath = "//div[@ng-show='wizard.active(1)']/ul/li/a")
    WebElement nextButton;


    public void selectingEntity() throws InterruptedException {
        Random rand = new Random();
        int count =selectEntity1.size();
        int value=rand.nextInt(count);
        Thread.sleep(1000);
        selectEntity1.get(value).click();
   }
    public void clickNextButton(){
        nextButton.click();
    }
}
