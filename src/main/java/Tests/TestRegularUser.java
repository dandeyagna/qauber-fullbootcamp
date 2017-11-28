package Tests;

import Data.DataProviders;
import Pages.HeaderPage;
import Pages.LoginPage;
import Pages.MainNavigationPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRegularUser extends BaseTest {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;
    @BeforeClass
    public void regUserBeforeClass(){
        loginPage= new LoginPage(driver);
        headerPage =new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        mainNavigationPage= new MainNavigationPage(driver);
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "usernamePasswordRU")
    public void regUserTest(String username, String password) throws InterruptedException {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(4000);
        Assert.assertTrue(mainNavigationPage.getAddReportLink().isDisplayed());
        Assert.assertTrue(mainNavigationPage.getReportsLink().isDisplayed());
        headerPage.clickUserLink();
        Thread.sleep(4000);
        try {
            Assert.assertFalse(profilePanelPage.getEditCompanyBtn().isDisplayed());
        }catch (Exception TimeoutException){
            //Edit company button is enabled on html page for all users but on UI you can not see it on regular user account
            //Cannot assert that this element is displayed or enabled.It is still there.
            //Time out error because element is not clickable
            System.out.println("Element is not displayed");
        }
        try {
            Assert.assertFalse(mainNavigationPage.getEntitiesLink().isDisplayed(),"If this button is displayed that means it's not a regular user ");
            Assert.assertFalse(mainNavigationPage.getUsersLink().isDisplayed(),"Fail, It's not a regular user");

        }catch (Exception NoSuchElementException){
            System.out.println("NoSuchElementException");
        }


    }
}

