package Tests;

import Data.DataProviders;
import Pages.EditProfilePage;
import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChangeName extends TestLogin {
    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;
    private HeaderPage headerPage;

    @BeforeClass
    public void profileBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        editProfilePage = new EditProfilePage(driver);
    }
    @Test(dependsOnMethods = "testLogin", dataProviderClass = DataProviders.class,dataProvider= "ChangeName")
    public void testChangeName(String name){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.setNameField(name);
        editProfilePage.clickUpdateNameBtn();
        String successMessage = editProfilePage.getSuccessMessage();
        Assert.assertEquals(successMessage, "The profile has been updated.");
    }
    @Test(dependsOnMethods = "testLogin")
    private void testErrorForChangeName(){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.setNameField(" ");
        editProfilePage.clickUpdateNameBtn();
        String requiredError = editProfilePage.getErrorRequired();
        Assert.assertEquals(requiredError, "This field is required");
    }
}
