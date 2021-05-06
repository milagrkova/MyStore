package magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

    private WebDriver driver;
    private WebDriverWait wait;
    By loginButton = By.className("login");
    By pageSubHeading = By.className("page-subheading");
    By username = By.id("email");
    By password = By.id("passwd");
    By submit = By.id("SubmitLogin");


    public SignIn(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void navigateToHomePage(String url){
        driver.get(url);
    }

    public void enterEmail(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(name);
    }

    public String getLoginHeaderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageSubHeading)).getText();
    }

    public void enterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }



}
