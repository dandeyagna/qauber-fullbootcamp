import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class loginTest {
    WebDriver dr;
    public LoginPage getLoginPage() {

        return loginPage;
    }

    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        dr.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        loginPage = new LoginPage(dr);
    }
    @Test
    public void test1() throws InterruptedException {
        String stringone = "matovbeck@gmail.com";
        String stringtwo = "qwerty1234";
        dr.get("http://fits.qauber.com/#/page/login");
        Thread.sleep(3000);
        loginPage.usernamefield(stringone);
        loginPage.Password(stringtwo);
        loginPage.loginButton();
    }
    @Test
    public void test2()  throws InterruptedException {
        String stringone = "matovbeck@gmail.com";
        String stringtwo = "Qwerty1234";
        dr.get("http://fits.qauber.com/#/page/login");
        Thread.sleep(3000);
        loginPage.usernamefield(stringone);
        loginPage.Password(stringtwo);
        loginPage.loginButton();
    }
}
