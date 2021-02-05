package dev.ric.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.junit.Cucumber;
import dev.ric.pages.LoginPage;

@RunWith(Cucumber.class)
public class TestRunner {
	
	public static WebDriver driver;
	public static LoginPage loginPage;
	
    @BeforeClass
    public static void setUp() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);		
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
