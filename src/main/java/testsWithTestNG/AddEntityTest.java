package testsWithTestNG;

import data.DataProviders;
import pages.EntitiesPage;
import pages.MainNavigationPage;
import pages.PaypalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEntityTest extends LoginTest {
    private MainNavigationPage mainNavigationPage;
    private EntitiesPage entitiesPage;
    private PaypalPage paypalPage;

    @Test(dependsOnMethods = "testLogin", dataProviderClass = DataProviders.class, dataProvider = "addEntityInfo")
    public void testAddEntity(String name, String country, String address1, String city, String state,
                              String zip, String phone, String email, String RUemail, String AUemail) throws InterruptedException {
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickEntitiesLink();
        entitiesPage = new EntitiesPage(driver);
        entitiesPage.clickAddEntityBtn();
        entitiesPage.setCompanyName(name);
        entitiesPage.setCountry(country);
        entitiesPage.setAddress1(address1);
        entitiesPage.setCity(city);
        entitiesPage.setState(state);
        entitiesPage.setZip(zip);
        entitiesPage.setPhone(phone);
        entitiesPage.setEmail(email);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.setAddEmailRU(RUemail);
        Thread.sleep(4000);
        entitiesPage.clickNextStepBtn();
        entitiesPage.setAddEmailFieldAU(AUemail);
        entitiesPage.clickNextStepBtn();
        entitiesPage.clickFinishBtn();
        Thread.sleep(25000);
        paypalPage = new PaypalPage(driver);
        paypalPage.paypalSwitchAndPay();
        Thread.sleep(10000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));
    }
}
