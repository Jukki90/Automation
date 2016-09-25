package Automation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Automation.SberbankMainPage;


public class AppTest
{
    public  WebDriver driver;
    private Properties properties;
    public  String baseUrl;
    private enum Browser {ie, firefox, chrome}


    public  void LoadProperties (String propPath) throws Exception{
        FileInputStream fis;
        Properties props = new Properties();


        try {
            props.load(new FileReader(new File(propPath)));
            this.properties = props;
            Browser browser = Browser.valueOf(properties.getProperty("browser"));
            File file;
            switch(browser){
                case firefox:
                    this.driver = new FirefoxDriver();
                    break;
                case ie:
                    file = new File("resources/IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    this.driver = new InternetExplorerDriver();
                    break;
                case chrome:
                    file = new File("resources/chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    this.driver = new ChromeDriver();
                    break;
            }

            this.driver.manage().window().maximize();
            this.baseUrl = properties.getProperty("baseUrl");
            this.driver.get(baseUrl);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    @Test
    public void testMyApp()
    {
        SberbankMainPage mainPage = new SberbankMainPage(driver);
        mainPage.typeKey("кредит");
        mainPage.clickSearch();
        SberbankResultPage resultPage = new SberbankResultPage(driver);
        assertTrue(driver.getPageSource().contains("Кредит «Бизнес-Доверие»"));
    }


    @Before
    public void setUp() throws Exception {
        LoadProperties ("properties.properties");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
