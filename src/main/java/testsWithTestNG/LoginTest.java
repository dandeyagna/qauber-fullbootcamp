package testsWithTestNG;

import data.DataProviders;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;


    @Test(dataProviderClass = DataProviders.class, dataProvider = "usernamePassword", priority = 0,groups = {"regression"})
    public void testLogin(String username, String password) throws InterruptedException {

        loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);//app is too slow
        Assert.assertTrue(loginPage.getUserProfileLink().isDisplayed());
    }
}
