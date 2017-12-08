package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEntity_reportPage {
    WebDriver dr;
    public AddEntity_reportPage(WebDriver driver) {

        this.dr = driver;
    }

    public List<WebElement> entity(){
        List<WebElement> element = dr.findElements(By.xpath("//input[@ng-model='wizard.report.key']"));
        return element;

    }
public WebElement get_entity(int index){
        return entity().get(index);


}

public void gotosubject_information(){
    WebElement element = dr.findElement(By.xpath("//li[@class='col-md-1 ph0' ][1]"));
    element.click();


}
}



