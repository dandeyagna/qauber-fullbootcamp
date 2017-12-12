package testsWithTestNG;

import pages.EditProfilePage;
import pages.HeaderPage;
import pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ProfileImageTest extends LoginTest {
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private EditProfilePage editProfilePage;

    @Test(dependsOnMethods = "testLogin", priority = 0, enabled = true)
    public void deletePicTest() {

        //precondition for this test : user should have a picture uploaded already
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditProfileBtn();
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.clickDeletePictureBtn();
        //for assertion i think i need to show that delete button is disable

        Assert.assertTrue(editProfilePage.getDeleteBtnDisable().isDisplayed());

    }

    @Test(dependsOnMethods = "testLogin", priority = 1, enabled = true)
    public void uploadImageTest() throws InterruptedException, AWTException, IOException {
        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditProfileBtn();
        editProfilePage = new EditProfilePage(driver);
        editProfilePage.clickSelectPictureBtn();
        editProfilePage.uploadImage();
        try {
            Assert.assertTrue(editProfilePage.getDeleteBtnDisable().isDisplayed());
            System.out.println("Picture was not upload");
        } catch (Exception e) {
            System.out.println("Delete button is enabled when picture is uploaded.Picture was uploaded");
        }
    }
}
