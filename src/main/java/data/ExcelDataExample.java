package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import pages.LoginPage;
import testsWithTestNG.BaseTest;

import static org.testng.Assert.assertTrue;


public class ExcelDataExample extends BaseTest {
     private LoginPage loginPage;

//	public DataDrivenTestExcel(String abc){
//		System.out.println("Hello "+abc);
//	}

    @Test(dataProvider = "dataProviderMethod")
    public void testLogin(String username, String password) throws InterruptedException {

        loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);//app is too slow
        Assert.assertTrue(loginPage.getUserProfileLink().isDisplayed());
    }

    @DataProvider
    public Object[][] dataProviderMethod() throws Exception {

        Object[][] testObjArray = readExcel(
                "waveLogin.xls", "loginData");
        //excel file should be an older version(97-2003 worked)
        return testObjArray;
    }

    public static Object[][] readExcel(String xlFilePath, String sheetName) throws Exception {
        String[][] tabArray = null;
        try {
            File f = new File(xlFilePath);
            Workbook workbook = Workbook.getWorkbook(f);
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow = 1;
            int startCol = 0;
            int ci, cj;
            int totalRows = 0;
            int totalCols = 0;
            totalRows = sheet.getRows();
            totalCols = sheet.getColumns();
            System.out.println("total cols = " + totalCols);
            System.out.println("total rows = " + totalRows);
            tabArray = new String[totalRows - 1][totalCols];
            ci = 0;
            for (int i = startRow; i < totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
                    tabArray[ci][cj] = sheet.getCell(j, i).getContents();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }


}
