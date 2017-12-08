package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver dr;
    public LoginPage (WebDriver driver){
        this.dr = driver;
    }
    public void usernamefield(String name){
        WebElement element = dr.findElement(By.xpath("//input[@name ='account_email']"));
        element.sendKeys(name);
    }

    public void Password (String password){
        WebElement element = dr.findElement(By.xpath("//input[@name = 'account_password']"));
        element.sendKeys(password);
    }

    public void loginButton (){
        WebElement element = dr.findElement(By.xpath("//button[text() = 'Login']"));
        element.click();
    }

}

