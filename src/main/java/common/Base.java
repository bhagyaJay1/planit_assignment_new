package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Base {
    public static WebDriver driver;


    /**
     * Method helps to get browsers Chrome, Firefox and ChromeHeadless-to run in CI/CD
     */
    @BeforeClass
    public void setupDriver(){
        if(TestData.browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver= new ChromeDriver(options);
        } else if (TestData.browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (TestData.browserName.equalsIgnoreCase("chromeHeadless")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--proxy-server='direct://'");
            chromeOptions.addArguments("--proxy-bypass-list=*");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--ignore-certificate-errors");

            driver= new ChromeDriver(chromeOptions);
        }

    }

    /**
     * Method helps to open the URL
     */
    @BeforeMethod
    public void gotoHome(){
        navigate(TestData.baseUrl);
    }


    /**
     * Method helps to quit the browser
     */
    @AfterClass
    public void terminate(){
        driver.quit();
    }

    /**
     * Method to click an element
     */
    public void click(By by){
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Method to click elements with index
     */
    public void clickFromList(By by, int index){
        List<WebElement> elements = driver.findElements(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
        elements.get(index).click();
    }

    /**
     * Method to enter text
     */
    public void type(By by, String text){
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Method to get text
     */
    public String getText(By by){
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Method to navigate to the given url
     */
    public void navigate(String url){
        driver.get(url);
    }

    /**
     * Method to check visibility of the web element in the page
     */
    public boolean isvisible(By by){
        try {
            WebElement element = driver.findElement(by);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method to wait in the page
     */
    public void waitUntil(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /**
     * Method to return the given web element
     */
    public WebElement getWebElement(By by){
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    };

    /**
     * Method to return list of elements
     */
    public List<WebElement> getWebElements(By by){
        List<WebElement> elements = driver.findElements(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        return elements;
    };


    /**
     * Method to get number of elements
     */
    public int getNumberOfElements(By by){
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        return elements.size();
    }
}
