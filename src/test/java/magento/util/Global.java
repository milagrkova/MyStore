package magento.util;

import magento.pages.Order;
import magento.pages.SignIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Global {
    public WebDriver driver;
    public WebDriverWait wait;
    public final int TIMEOUT = 10;
    public SignIn signIn;
    public Order order;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver5");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIMEOUT);
        driver.manage().window().maximize();
        signIn = new SignIn(driver, wait);
        order = new Order(driver, wait);
    }

    @AfterMethod
    public  void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
//        driver.quit();
    }
}

