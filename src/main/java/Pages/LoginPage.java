package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver dr;
    public LoginPage(WebDriver dr){
        this.dr=dr;

    }
    //*[@id='exampleInputEmail1']
    public WebElement userNamefield(){

        return dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
    }

    public WebElement userPassword(){

        return dr.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
    }
    public void loginButton() throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = dr.findElement(By.xpath("//button[@type='submit']"));
        el.click();
    }
}
