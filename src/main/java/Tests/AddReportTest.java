package Tests;

import Data.DataProviders;
import Pages.AddReportPage;
import Pages.MainNavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReportTest extends LoginTest {
    private MainNavigationPage mainNavigationPage;
    private AddReportPage addReportPage;
    //too many input fields. this test can be split for each page in particular

    @Test(dependsOnMethods = "testLogin", dataProviderClass = DataProviders.class, dataProvider = "addReportInfo")
    public void testAddReport(String caseId, String suspectType, String lastName, String firstName,
                              String middleName, String nickname, String dob, String sex, String race, String height,
                              String weight, String hairColor, String hairLength, String hairStyle, String eyeColor,
                              String complexion,String teeth, String handPreference, String language, String streetAddress,
                              String country, String city, String state, String zip,String phone, String email,String ssn,
                              String driverLicenseN,String idState, String otherId,String otherCountry, String otherIdState,
                              String otherIdType, String schoolName, String schoolAddress, String schoolCity, String schoolState,
                              String schoolZip, String schoolPhone,String parentName, String parentAddress, String parentCity,
                              String parentState,String parentZip, String parentPhone, String occupation, String employerName, String employerAddress,
                              String employerCity,String employerState,String employerZip, String employerPhone) throws InterruptedException {
        mainNavigationPage=new MainNavigationPage(driver);
        mainNavigationPage.clickAddReportLink();
        //click on add report link
        addReportPage = new AddReportPage(driver);
        String title = addReportPage.getHeaderText();
        Assert.assertEquals(title, "Field Interview Card");
        //select an entity
        addReportPage.clickEntityNameRBtn();
        //move to next page
        addReportPage.clickNextBtn();
        String title2 =addReportPage.getSubjectInformationTitle();
        Assert.assertEquals(title2, "Subject Information");
        //Add information about suspect
        addReportPage.setCaseId(caseId);
        addReportPage.setSuspectType(suspectType);
        addReportPage.setLastName(lastName);
        addReportPage.setFirstName(firstName);
        addReportPage.setMiddleName(middleName);
        addReportPage.setNickName(nickname);
        addReportPage.setDOB(dob);
//        int age = addReportPage.calculateAge();//fir this fields need to import something.is not working in this new version
//        addReportPage.setAge(" " + age);
        addReportPage.setSex(sex);
        addReportPage.setRace(race);
        addReportPage.setHeight(height);
        addReportPage.setWeight(weight);
        addReportPage.setBuild();
        addReportPage.setHeirColor(hairColor);
        addReportPage.setHeirLength(hairLength);
        addReportPage.setHeirStyle(hairStyle);
        addReportPage.setEyeColor(eyeColor);
        addReportPage.setComplexion(complexion);
        addReportPage.setTeeth(teeth);
        addReportPage.setHandPreference(handPreference);
        addReportPage.setPrimaryLanguage(language);
        addReportPage.setStreetAddress(streetAddress);
        addReportPage.setCountry(country);
        addReportPage.setCity(city);
        addReportPage.setState(state);
        addReportPage.setZip(zip);
        addReportPage.setPhone(phone);
        addReportPage.setEmail(email);
        addReportPage.clickDriverRadioBtn();
        addReportPage.clickNextBtn2();
        String title3 =addReportPage.getIdentifiersTitle();
        Assert.assertEquals(title3, "Identifiers");
        addReportPage.clickCheckBoxes();
        addReportPage.clickNextBtn3();
        String title4 = addReportPage.getIdInformationTitle();
        Assert.assertEquals(title4, "ID Information");
        addReportPage.setSocialSecurity(ssn);
        addReportPage.setDriverLicense(driverLicenseN);
        addReportPage.setIdState(idState);
        addReportPage.setOtherId(otherId);
        addReportPage.setOtherIdCountry(otherCountry);
        addReportPage.setOtherIdState(otherIdState);
        addReportPage.setOtherIdType(otherIdType);
        //adding school information
        addReportPage.setSchoolName(schoolName);
        addReportPage.setSchoolAddress(schoolAddress);
        addReportPage.setSchoolCity(schoolCity);
        addReportPage.setSchoolState(schoolState);
        addReportPage.setSchoolZip(schoolZip);
        addReportPage.setSchoolPhone(schoolPhone);
        //parent information
        addReportPage.setParentName(parentName);
        addReportPage.setParentAddress(parentAddress);
        addReportPage.setparentCity(parentCity);
        addReportPage.setparentState(parentState);
        addReportPage.setparentZip(parentZip);
        addReportPage.setparentPhone(parentPhone);
        //employer information
        addReportPage.setOccupation(occupation);
        addReportPage.setEmployerName(employerName);
        addReportPage.setEmployerAddress(employerAddress);
        addReportPage.setEmployerCity(employerCity);
        addReportPage.setEmployerState(employerState);
        addReportPage.setEmployerZip(employerZip);
        addReportPage.setEmployerPhone(employerPhone);
        //move to next page
        addReportPage.clickNextBtn4();
        String title5 = addReportPage.getDistributionTitle();//move to next tab
        Assert.assertEquals(title5, "Gang Membership");

        //in progress


        /*
        String title6 = addReportPage.getVehicleTitle();
        Assert.assertEquals(title6, "Vehicle");
        String title7 = addReportPage.getPhotosTitle();
        Assert.assertEquals(title7, "Photos");
        String title8 = addReportPage.getReviewInfo();
        Assert.assertEquals(title8, "Preview");
        */
    }
}
