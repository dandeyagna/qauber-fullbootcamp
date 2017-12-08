package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Previewpage {
    WebDriver dr;


    public Previewpage(WebDriver dr){
        this.dr = dr;

    }
    public void gotopreviewbutton(){
        dr.findElement(By.xpath("//h4/div[@class='fa fa-check-square size']"));
    }
    public void gotopublishreport(){
        dr.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));

    }

}
