package magento.tests;

import magento.util.Global;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends Global {

    String url = "http://automationpractice.com/index.php";

    @DataProvider(name = "Personal info")
    public Object[][] personalInfoData() {
        return new Object[][]{
                {"mila.grkova@gmail.com", "@Dm!N2021"}
        };
    }
    @Test (dataProvider = "Personal info")
    public void testcaseLogin(String name, String pass) {
        signIn.navigateToHomePage(url);
        signIn.enterEmail(name);
        signIn.enterPassword(pass);
        signIn.clickSubmit();
    }
}
