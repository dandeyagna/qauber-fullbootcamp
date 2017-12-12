package testsWithTestNG;

import data.DataProviders;
import pages.EditCompanyPage;
import pages.HeaderPage;
import pages.ProfilePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class UpdateCompanyInfoTest extends LoginTest {

    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private EditCompanyPage editCompanyPage;



    @Test(dataProviderClass = DataProviders.class,dataProvider="updateCompanyInfo",priority = 0, dependsOnMethods = "testLogin")
    public void testUpdateCompanyInfo(String name, String country, String address1, String address2, String city,
                                      String state,String zip,String phone, String email, String notes) throws InterruptedException {

        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage = new EditCompanyPage(driver);
        editCompanyPage.setCompanyName(name);
        editCompanyPage.setCountry(country);
        editCompanyPage.setAddress1(address1);
        editCompanyPage.setAddress2(address2);
        editCompanyPage.setCity(city);
        editCompanyPage.setState(state);
        editCompanyPage.setZip(zip);
        editCompanyPage.setPhone(phone);
        editCompanyPage.setEmail(email);
        editCompanyPage.setNotes(notes);
        editCompanyPage.clickUpdateBtn();
        Thread.sleep(3000);

        Assert.assertTrue(editCompanyPage.getSuccessUpdateMessage().isDisplayed());
        Thread.sleep(4000);

    }

    @Test(priority = 1,dependsOnMethods = "testLogin")
    public void testRequiredFields() throws InterruptedException {

        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage = new EditCompanyPage(driver);
        editCompanyPage.setCompanyName("");
        editCompanyPage.setCountry("Select a country");
        editCompanyPage.setAddress1("");
        editCompanyPage.setAddress2("");
        editCompanyPage.setCity("");
        editCompanyPage.setStateTextField("");
        editCompanyPage.setZip("");
        editCompanyPage.setPhone("");
        editCompanyPage.setEmail("");
        editCompanyPage.setNotes("");
        editCompanyPage.clickUpdateBtn();

        editCompanyPage.getAllRequiredFields();
        int x = editCompanyPage.countRequiredFields();
        System.out.println(x);

        Assert.assertTrue(x==8);//8 fields are required on this form
    }
}
