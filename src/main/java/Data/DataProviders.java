package Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "usernamePassword")//Super Admin User
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{{"buquxahu@cars2.club","kisulea"}};
    }
    @DataProvider(name = "usernamePasswordRU")//regularAdmin User
    public static Object[][] DataProvider(){
        return new Object[][]{{"client4@amail.club","client4"}};
    }

    @DataProvider(name = "ChangeName")
    public static Object[][] changeNameData(){
        Object[][] data = new Object[1][1];
        data[0][0]= RandomStringUtils.randomAlphabetic(9).toLowerCase();
        return data;
    }
    @DataProvider(name = "ChangePasswordPositive")
    public static Object[][] changePasswordData(){

        Object[][] data = new Object[1][3];
        data[0][0]= "kisulea";
        data[0][1] = "kisulea";
        data[0][2] = "kisulea";
        return data;
    }
    @DataProvider(name = "ChangePasswordNegative")
    public static Object[][] changePasswordNegative(){
        return new Object[][]{
                {"kisulea12345","kisulea","kisulea"},
                {"","phillipa","phillipa"},
                {"kisulea", "1234n","1234n"},
                {"kisulea","kisulea","12345b"},
                {"kisulea","kisulea",""}


        };
    }
    @DataProvider(name = "updateCompanyInfo")
    public static Object[][] updateCompanyInfo(){
        Object[][] data = new Object[1][12];
        data[0][0] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//company name
        data[0][1] = "United States";//country
        data[0][2]=RandomStringUtils.randomNumeric(3)+" "+RandomStringUtils.randomAlphabetic(5)+ " Str.";//address1
        data[0][3]="Apt. "+ RandomStringUtils.randomNumeric(2);//address2
        data[0][4]=RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][5]="Vermont";//state
        data[0][6]=RandomStringUtils.randomNumeric(5);//zip
        data[0][7]=RandomStringUtils.randomNumeric(10);//phone
        data[0][8]=RandomStringUtils.randomAlphabetic(8)+"@cars2.club";//email
        data[0][9]=RandomStringUtils.randomAlphabetic(100).toLowerCase();//notes
        data[0][10]="buquxahu@cars2.club";
        data[0][11]="kisulea";
        return  data;
    }

    @DataProvider(name = "addEntityInfo")
    public static Object[][] addEntityInfo(){
        Object[][] data = new Object[1][10];
        data[0][0] = RandomStringUtils.randomAlphabetic(8).toLowerCase();//company name
        data[0][1] = "United States";//country
        data[0][2]=RandomStringUtils.randomNumeric(3)+" "+RandomStringUtils.randomAlphabetic(5)+ " Str.";//address1
        data[0][3]=RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][4]="Vermont";//state
        data[0][5]=RandomStringUtils.randomNumeric(5);//zip
        data[0][6]=RandomStringUtils.randomNumeric(10);//phone
        data[0][7]=RandomStringUtils.randomAlphabetic(8)+"@cars2.club";//email
        data[0][8]=RandomStringUtils.randomAlphabetic(8)+"@cars2.club";//emailRU
        data[0][9]=RandomStringUtils.randomAlphabetic(8)+"@cars2.club";//emailAU

        return  data;
    }
    @DataProvider(name = "addReportInfo")
    public static Object[][] addReportInfo(){
        Object[][] data = new Object[1][12];
        data[0][0] = RandomStringUtils.randomAlphabetic(8).toLowerCase();// name number
        data[0][1] = "United States";//country
        data[0][2]=RandomStringUtils.randomNumeric(3)+" "+RandomStringUtils.randomAlphabetic(5)+ " Str.";//address1
        data[0][3]="Apt. "+ RandomStringUtils.randomNumeric(2);//address2
        data[0][4]=RandomStringUtils.randomAlphabetic(5).toLowerCase();//city
        data[0][5]="Vermont";//state
        data[0][6]=RandomStringUtils.randomNumeric(5);//zip
        data[0][7]=RandomStringUtils.randomNumeric(10);//phone
        data[0][8]=RandomStringUtils.randomAlphabetic(8)+"@cars2.club";//email
        data[0][9]=RandomStringUtils.randomAlphabetic(100).toLowerCase();//notes
        data[0][10]="buquxahu@cars2.club";
        data[0][11]="kisulea";
        return  data;
    }
}
