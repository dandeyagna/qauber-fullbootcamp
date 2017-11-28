package Tests;

import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSignOut extends TestLogin {
    private ProfilePanelPage profilePanelPage;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    @BeforeClass
    public void signOutBeforeClass(){
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
    }
    @Test(dependsOnMethods = "testLogin")
    public void testSignOut(){
        headerPage.clickUserLink();
        profilePanelPage.clickSignOut();
        Assert.assertTrue(loginPage.getSignInToContinue().isDisplayed());
    }
}
