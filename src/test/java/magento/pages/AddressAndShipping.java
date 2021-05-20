package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class AddressAndShipping {

    public WebDriver driver;
    public WebDriverWait wait;
    By updateButton = By.xpath("//*[@id=\"address_delivery\"]/li[7]/a/span");
    By address = By.id("address1");
    By save = By.id("submitAddress");
    By submitButton = By.xpath("//*[@id=\"center_column\"]/form/p/button");
    By termsCheckBox = By.id("uniform-cgv");
    By submitShipping = By.name("processCarrier");


    public AddressAndShipping(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickUpdate(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateButton)).click();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void changeAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys("Test address");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(save)).click();
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

    public void checkTerms(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsCheckBox)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitShipping)).click();
    }

}
