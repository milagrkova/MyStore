package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Order {

    private WebDriver driver;
    private WebDriverWait wait;
    By women = By.className("sf-with-ul");
    By printedDress = By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[1]/div/a[1]/img");
    By printedDressDesc = By.id("short_description_content");
    By pinkColor = By.className("color_pick");
    By quantity = By.id("quantity_wanted");
    By iconPlus = By.className("icon-plus");
    By submit = By.id("add_to_cart");
    By productAdded = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/text()");
    By popUp = By.className("clearfix");
    By proceedToCheckOut = By.className("button-medium");
    By dropDownSize = By.id("uniform-group_1");
    By size = By.className("attribute_select");


    public Order(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void selectCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(women)).click();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void chooseProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(printedDress)).click();
    }

    public void swichToIframe(){
        driver.switchTo().frame(0);
    }
    public String getPrintedDressDescriptionText() throws InterruptedException {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(printedDressDesc)).getText();
    }

    public void choosePinkColor() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pinkColor)).click();
    }

    public void chooseQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(iconPlus)).click();
    }

    public void chooseSize(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownSize)).click();
        WebElement mySelectElement = driver.findElement(size);
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByIndex(1);
    }

    public void addToCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public String getProductedAddedSuccesfullyText() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUp));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productAdded)).getText();
    }

    public void proceedToCheckOutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOut)).click();
    }




}
