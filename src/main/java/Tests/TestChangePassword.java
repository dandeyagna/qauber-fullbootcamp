package Tests;

import Data.DataProviders;
import Pages.EditProfilePage;
import Pages.HeaderPage;
import Pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChangePassword extends TestLogin {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;

    @BeforeClass
    public void changePassBeforeClass(){
        headerPage = new HeaderPage(driver);
        profilePanelPage = new ProfilePanelPage(driver);
        editProfilePage = new EditProfilePage(driver);
    }
    @Test(dependsOnMethods = "testLogin",dataProviderClass = DataProviders.class,dataProvider= "ChangePasswordPositive", enabled = false, groups = {"editProfile"})
    public void testChangePasswordPositive(String currentPass, String newPass, String confirmPass){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.setCurrentPassword(currentPass);
        editProfilePage.setNewPassword(newPass);
        editProfilePage.setConfirmNewPassword(confirmPass);
        editProfilePage.clickChangePassBtn();
        String successMessage = editProfilePage.getSuccessMessage();
        Assert.assertEquals(successMessage, "The password has been changed.");
    }

    @Test(dependsOnMethods = "testLogin",dataProviderClass = DataProviders.class,dataProvider= "ChangePasswordNegative")
    public void testChangePasswordErrors(String currentPass, String newPass, String confirmPass){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.setCurrentPassword(currentPass);
        editProfilePage.setNewPassword(newPass);
        editProfilePage.setConfirmNewPassword(confirmPass);
        editProfilePage.clickChangePassBtn();
        try {
            if(editProfilePage.getVisiblErrorCurrentPassWrongElement().isDisplayed()){
                String error1 = editProfilePage.getErrorCurrentPassWrong();
                Assert.assertEquals(error1, "Your current password is different");
                System.out.println("-----------------------");
                System.out.println("Your current password is wrong.");
            }
        }catch (Exception e){
            System.out.println("Couldn't find error1");
        }
        try{
            if(editProfilePage.getVisiblErrorInput6CharElement().isDisplayed()){
            String error2 = editProfilePage.getErrorWrongInput();
            Assert.assertEquals(error2,"Input should be 6-20 length");
                System.out.println("-----------------------");
                System.out.println("Input should be 6-20 length.");
        }
        }catch (Exception e){
            System.out.println("Couldn't find error2");
        }
        try{
            if(editProfilePage.getVisiblErrorNotMatchElement().isDisplayed()){
            String error3 =editProfilePage.getErrorNotMatch();
            Assert.assertEquals(error3,"Password does Not match");
                System.out.println("-----------------------");
                System.out.println("Password does Not match");
        }
        }catch (Exception e){
            System.out.println("Couldn't find error3");
        }
        try{
            if (editProfilePage.getVisiblErrorRequiredElement().isDisplayed()) {
            String error4 = editProfilePage.getErrorRequired();
            Assert.assertEquals(error4, "This field is required");
                System.out.println("-----------------------");
                System.out.println("This field is required");
        }
        }catch (Exception e){
            System.out.println("Couldn't find error4");
        }
    }

    @Test(dependsOnMethods = "testLogin")
    //For this test we need to assert that all fields are encrypted
    //For this we need to check that all this fields have in html code type "password"
    public void testPasswordEncrypted(){
        headerPage.clickUserLink();
        profilePanelPage.clickEditProfileBtn();
        editProfilePage.getAllPasswordEncryptedFields();
       int passwordFields = editProfilePage.getNrOfPasswordFields();
        Assert.assertTrue(passwordFields==3,"Password is not encrypted in all password fields.");
    }

}
