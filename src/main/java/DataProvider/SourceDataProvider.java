package DataProvider;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class SourceDataProvider {
    Random rand = new Random();
    public String generateRandomNumber(){
        return Integer.toString(rand.nextInt(5000));
    }
    @org.testng.annotations.DataProvider(name="loggingIn")
    public Object[][] loggingIn() throws Exception{
        Object[][] registeredUser = {{"cubo@nada.ltd","abcdefgh"}};
        return  registeredUser;
    }
    @org.testng.annotations.DataProvider(name="insertingIdentifierData")
    public Object[][] insertingIdentifierData() throws Exception {
        Object[][] identifierObject = {
                {generateRandomNumber(),"sam","jhon","Dragon","","","","","","","Santa clara"},
                {generateRandomNumber(),"jhon","nathin","","Black mark","","","","","","Santa clara"},
                {generateRandomNumber(),"sunny","lion","","","on leg","","","","","Santa clara"},
                {generateRandomNumber(),"sam","jhon","","","","on hand","","","","Santa clara"},
                {generateRandomNumber(),"jhon","nathin","","","","","yes","","","Santa clara"},
                {generateRandomNumber(),"sunny","lion","","","","","","yes","","Santa clara"},
                {generateRandomNumber(),"sunny","lion","","","","","","","yes","Santa clara"},
                {generateRandomNumber(),"lincon","londan","spider","hello","yes","yes","yes","yes","yes","Santa clara"},
                {generateRandomNumber(),"smitha","raj","","","","","","","","San Jose"}
        };
        return identifierObject;
    }
}
