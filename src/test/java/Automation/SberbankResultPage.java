package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;


public class SberbankResultPage {
    private final static String RESULT_ELEMENT = "//div[@class=\"extended-search\"]";
    private WebDriver driver;


    public SberbankResultPage(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 180);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RESULT_ELEMENT)));
    }

}