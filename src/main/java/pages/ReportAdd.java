package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportAdd {

    WebDriver dr;
     public ReportAdd(WebDriver dr){
         this.dr=dr;
     }

     public void addReportLink(){
         dr.findElement(By.xpath("//span[contains(text(),'Add Report')]"));
     }


}
