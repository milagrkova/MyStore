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
                {"testiramila@gmail.com", "123456"}
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
        order.chooseQuantity();
        order.chooseSize();
        order.addToCard();
        order.switchToMainArea();
        Assert.assertEquals(order.getProductedAddedSuccesfullyText(), "Printed Dress");
        order.proceedToCheckOutButton();
        shoppingCard.cardQuantityDown();
        Assert.assertEquals(shoppingCard.getPrintedDressText(), "Color : Beige, Size : M");
        Assert.assertEquals(shoppingCard.getTotalPriceText(), "$103.98");
        shoppingCard.scrollDown();
        Assert.assertEquals(shoppingCard.getAddressNameText(), "Mila Testira");
        Assert.assertEquals(shoppingCard.getAddressAddressText(), "Skopje, Michigan 00000");
        Assert.assertEquals(shoppingCard.getAddressPhoneText(), "0909090909");
        shoppingCard.proceed();
        addressAndShipping.scrollDown();
        addressAndShipping.clickUpdate();
        addressAndShipping.changeAddress();
        addressAndShipping.scrollDown();
        addressAndShipping.clickSubmit();
        addressAndShipping.checkTerms();
        Assert.assertEquals(payment.getProductPriceText(), "$50.99");
        Assert.assertEquals(payment.getShippingPriceText(), "$2.00");
        Assert.assertEquals(payment.getTotalPriceText(), "Total products $50.99");
        payment.scrollDown();
        payment.payment();
        Assert.assertEquals(payment.getTotalAmountText(), "$52.99");
        Assert.assertEquals(payment.getBankWirePaymentText(), "BANK-WIRE PAYMENT.\n" +
                "You have chosen to pay by bank wire. Here is a short summary of your order:\n" +
                "- The total amount of your order comes to: $52.99 (tax incl.)\n" +
                "- We allow the following currency to be sent via bank wire: Dollar\n" +
                "- Bank wire account information will be displayed on the next page.\n" +
                "- Please confirm your order by clicking \"I confirm my order.\".");
        payment.confirmOrder();
        Assert.assertEquals(payment.getCompleteOrderText(), "Your order on My Store is complete.");

    }
}
