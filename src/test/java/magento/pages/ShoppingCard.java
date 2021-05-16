package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCard {

    private WebDriver driver;
    private WebDriverWait wait;
    By minusCardQty = By.className("icon-minus");
    By printedDressDesc = By.xpath("//a[contains(text(),'Color : Pink, Size : M')]");
    By totalPrice = By.id("total_product_price_4_17_502642");
    By adressName = By.className("address_name");
    By adressAddress = By.className("address_address1");
    By adddressCity = By.className("address_city");
    By addressPhone = By.className("address_phone_mobile");
    By proceed = By.className("standard-checkout");

    public ShoppingCard(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void cardQuantityDown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(minusCardQty)).click();
    }

    public String getPrintedDressText() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(printedDressDesc)).getText();
    }

    public String getTotalPriceText() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    public String getAddressNameText() throws InterruptedException {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(adressName)).getText();
    }
    public String getAddressAddressText() throws InterruptedException {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(adddressCity)).getText();
    }
    public String getAddressCityText() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adressAddress)).getText();
    }
    public String getAddressPhoneText() throws InterruptedException {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(addressPhone)).getText();
    }
    public void proceed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceed)).click();
    }
}
