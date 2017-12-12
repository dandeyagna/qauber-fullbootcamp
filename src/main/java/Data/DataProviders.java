package data;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "usernamePassword")//Super Admin User
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{{"buquxahu@cars2.club", "kisulea"}};
    }

    @DataProvider(name = "usernamePasswordRU")//regularAdmin User
    public static Object[][] DataProvider() {
        return new Object[][]{{"client4@amail.club", "client4"}};
    }

    @DataProvider(name = "ChangeName")
    public static Object[][] changeNameData() {
        Object[][] data = new Object[1][1];
        data[0][0] = RandomStringUtils.randomAlphabetic(9).toLowerCase();
        return data;
    }

    @DataProvider(name = "ChangePasswordPositive")
    public static Object[][] changePasswordData() {

        Object[][] data = new Object[1][3];
        data[0][0] = "kisulea";
        data[0][1] = "kisulea";
        data[0][2] = "kisulea";
        return data;
    }

    @DataProvider(name = "ChangePasswordNegative")
    public static Object[][] changePasswordNegative() {
        return new Object[][]{
                {"kisulea12345", "kisulea", "kisulea"},
                {"", "phillipa", "phillipa"},
                {"kisulea", "1234n", "1234n"},
                {"kisulea", "kisulea", "12345b"},
                {"kisulea", "kisulea", ""}


        };
    }

    @DataProvider(name = "updateCompanyInfo")
    public static Object[][] updateCompanyInfo() {
        Object[][] data = new Object[1][10];
        data[0][0] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//company name
        data[0][1] = "United States";//country
        data[0][2] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(5) + " Str.";//address1
        data[0][3] = "Apt. " + RandomStringUtils.randomNumeric(2);//address2
        data[0][4] = RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][5] = "Vermont";//state
        data[0][6] = RandomStringUtils.randomNumeric(5);//zip
        data[0][7] = RandomStringUtils.randomNumeric(10);//phone
        data[0][8] = RandomStringUtils.randomAlphabetic(8) + "@cars2.club";//email
        data[0][9] = RandomStringUtils.randomAlphabetic(100).toLowerCase();//notes

        return data;
    }

    @DataProvider(name = "addEntityInfo")
    public static Object[][] addEntityInfo() {
        Object[][] data = new Object[1][10];
        data[0][0] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//company name
        data[0][1] = "US";//country
        data[0][2] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(5) + " Str.";//address1
        data[0][3] = RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][4] = "NJ";//state
        data[0][5] = RandomStringUtils.randomNumeric(5);//zip
        data[0][6] = RandomStringUtils.randomNumeric(10);//phone
        data[0][7] = RandomStringUtils.randomAlphabetic(8) + "@cars2.club";//email
        data[0][8] = RandomStringUtils.randomAlphabetic(8) + "@cars2.club";//emailRU
        data[0][9] = RandomStringUtils.randomAlphabetic(8) + "@cars2.club";//emailAU

        return data;
    }

    @DataProvider(name = "addReportInfo")
    public static Object[][] addReportInfo() {
        Object[][] data = new Object[1][62];
        data[0][0] = RandomStringUtils.randomNumeric(3);//caseId
        data[0][1] = "Suspect";//suspect type
        data[0][2] = RandomStringUtils.randomAlphabetic(7).toLowerCase();//last name
        data[0][3] = RandomStringUtils.randomAlphabetic(6).toLowerCase();//first name
        data[0][4] = RandomStringUtils.randomAlphabetic(1).toLowerCase();//middle name
        data[0][5] = RandomStringUtils.randomAlphabetic(3).toLowerCase();//nickname
        data[0][6] = "04271992";//dob
        data[0][7] = "M";//select sex M,F,U
        data[0][8] = "Unknown";//select race
        data[0][9] = "604";//height
        data[0][10] = "1500";//weight
        data[0][11] = "BLO";// select hairColor
        data[0][12] = "Short";// select hairLength
        data[0][13] = "Afro";// select hairStyle
        data[0][14] = "BLU";// select eyeColor
        data[0][15] = "Medium";// select complexion
        data[0][16] = "Missing";// select teeth (Gold/Silver/Rotten)
        data[0][17] = "Right";//select hand preference(left/Unknown)
        data[0][18] = "English";//Type primary language
        data[0][19] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(8).toLowerCase();//type streetAddress
        data[0][20] = "US";//select country
        data[0][21] = RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][22] = "NJ";//select State
        data[0][23] = RandomStringUtils.randomNumeric(5);//zip
        data[0][24] = RandomStringUtils.randomNumeric(10);//phone
        data[0][25] = RandomStringUtils.randomAlphabetic(8) + "@cars2.club";//email

        //id information
        data[0][26] = RandomStringUtils.randomNumeric(9);//social security number
        data[0][27] = "F255-921-50-094-0";//driver license
        data[0][28] = "CA";//select State
        data[0][29] = "RO " + RandomStringUtils.randomNumeric(5);//other id number
        data[0][30] = "RO";//other country
        data[0][31] = RandomStringUtils.randomAlphabetic(6);//other state
        data[0][32] = "Passport";//other id type

        //school information
        data[0][33] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//school name
        data[0][34] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(8).toLowerCase();//schoolAddress
        data[0][35] = RandomStringUtils.randomAlphabetic(5);//school city
        data[0][36] = "CA";//school state
        data[0][37] = RandomStringUtils.randomNumeric(5);//schoolZip
        data[0][38] = RandomStringUtils.randomNumeric(10);//school phone

        //parent information
        data[0][39] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//Parent name
        data[0][40] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(8).toLowerCase();//Parent Address
        data[0][41] = RandomStringUtils.randomAlphabetic(5);//parent city
        data[0][42] = "CA";//parent state
        data[0][43] = RandomStringUtils.randomNumeric(5);//parent Zip
        data[0][44] = RandomStringUtils.randomNumeric(10);//parent phone

        //Employer information
        data[0][45] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//occupation
        data[0][46] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//employer name
        data[0][47] = RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomAlphabetic(8).toLowerCase();//employer Address
        data[0][48] = RandomStringUtils.randomAlphabetic(5);//employer city
        data[0][49] = "NJ";//employer state
        data[0][50] = RandomStringUtils.randomNumeric(5);//employer Zip
        data[0][51] = RandomStringUtils.randomNumeric(10);//employer phone

        //gang information
        data[0][52] = RandomStringUtils.randomAlphabetic(25).toLowerCase();//reasonForStop
        data[0][53] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//locationOfStop
        data[0][54] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//dispositionOfStop
        data[0][55] = RandomStringUtils.randomAlphabetic(5);//gangName
        data[0][56] = RandomStringUtils.randomNumeric(1) + " years";//howLong
        data[0][57] = RandomStringUtils.randomAlphabetic(125);//otherInformation
        data[0][58] = RandomStringUtils.randomAlphabetic(10);//beat

        //vehicle information
        data[0][59] = RandomStringUtils.randomNumeric(10);//vehicleLicense
        data[0][60] = RandomStringUtils.randomAlphabetic(15);//vehicleMake
        data[0][61] = RandomStringUtils.randomAlphabetic(10);//vehicleColor


        return data;
    }
}
