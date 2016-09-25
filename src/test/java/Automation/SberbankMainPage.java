package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;


public class SberbankMainPage {
    private final static String SEARCH_INPUT_FIELD = "//input[@class=\"form-control\"]";
    private final static String SERARCH_BUTTON = "//span[@class=\"glyphicon form-control-feedback glyphicon-search\"]";
    private WebDriver driver;

    public SberbankMainPage(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_INPUT_FIELD)));
    }

    public  SberbankMainPage typeKey(String key) {
        if (key != null){
            driver.findElement(By.xpath(SEARCH_INPUT_FIELD)).sendKeys(key);
        }
        return this;
    }

    public  SberbankMainPage clickSearch(){
        driver.findElement(By.xpath(SERARCH_BUTTON)).click();
        return this;
    }
}