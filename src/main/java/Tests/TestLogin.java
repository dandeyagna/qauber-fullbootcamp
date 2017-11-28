package Tests;

import Data.DataProviders;
import Pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {
    private LoginPage loginPage;
    @BeforeClass(groups = {"editProfile"})
    public void loginBeforeClass(){
        loginPage = new LoginPage(driver);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider= "usernamePassword", groups = {"editProfile"}, dependsOnMethods = "assertLogo")
    public void testLogin(String username, String password) throws InterruptedException {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);//app is too slow
        Assert.assertTrue(loginPage.getUserProfileLink().isDisplayed());
    }

}
