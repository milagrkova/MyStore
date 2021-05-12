package magento.tests;

import magento.util.Global;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BuyDressTest extends Global {

    String url = "http://automationpractice.com/index.php";

    @DataProvider(name = "Personal info")
    public Object[][] personalInfoData() {
        return new Object[][]{
                {"mila.grkova@gmail.com", "@Dm!N2021"}
        };
    }
    @Test (dataProvider = "Personal info")
    public void testcaseLogin(String name, String pass) throws InterruptedException {
        signIn.navigateToHomePage(url);
        signIn.enterEmail(name);
        Assert.assertEquals(signIn.getLoginHeaderText(), "ALREADY REGISTERED?");
        signIn.enterPassword(pass);
        signIn.clickSubmit();
        Assert.assertEquals(signIn.getMyAccountText(), "Welcome to your account. Here you can manage all of" +
                " your personal information and orders.");
        order.selectCategory();
        order.scrollDown();
        order.chooseProduct();
        order.swichToIframe();
        Assert.assertEquals(order.getPrintedDressDescriptionText(), "Printed evening dress with straight" +
                " sleeves with black thin waist belt and ruffled linings.");
        order.choosePinkColor();
        order.chooseQuantity();
        order.chooseSize();
        order.addToCard();
        order.switchToMainArea();
//        Assert.assertEquals(order.getProductedAddedSuccesfullyText(), "Product successfully added to your shopping cart\n" +
//                "\t\t\t\t");
        order.proceedToCheckOutButton();


    }
}
