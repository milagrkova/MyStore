package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {

    public WebDriver driver;
    public WebDriverWait wait;
    By totalProductPrice = By.id("total_product");
    By totalShippingPrice = By.id("total_shipping");
    By totalPrice = By.id("total_price");
    By payByBankWire = By.className("bankwire");
    By totalAmount = By.id("amount");
    By currency = By.xpath("//*[@id=\"center_column\"]/form/div/p[3]/input");
    By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button");
    By completeOrder = By.className("cheque-indent");

    public Payment(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getProductPriceText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalProductPrice)).getText();
    }

    public String getShippingPriceText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalShippingPrice)).getText();
    }

    public String getTotalPriceText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void payment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payByBankWire)).click();
    }

    public String getTotalAmountText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalAmount)).getText();
    }

    public String getCurrencyText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(currency)).getText();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder)).click();
    }

    public String getCompleteOrderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeOrder)).getText();
    }
}
