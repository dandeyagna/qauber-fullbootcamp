package pom1.tests;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "loginCredential")
    public static Object[][] loggingIn() {
        return new Object[][]{{"amruthaa.bkk@gmail.com", "Amruthaa"}};
    }

	@DataProvider(name = "addingEntity")
	public static Object[][] AddingEntity(){
        return new Object[][] {{"seleniumfitt114 " ,"2905 Stenderway "," Central way", " Santa Clara" ," 94090" ," 5409872346" , "amruthaa@gmail.com" , "Adding entity to the organization ", "selenium@gmail.com" ," selenium1@gmail.com"  }};
    }
}
