package QAExams.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import QAExams.PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	
	public WebDriver driver;
	public HomePage Homepage;
	public WebDriver InitializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//QAExams//resources/GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		}
	
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
		 //Firefox
		}
		
		else if (browserName.equalsIgnoreCase("Edge"))
		{
			//Edge
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
    
	@BeforeTest(alwaysRun=true)
	 public HomePage LaunchApp() throws IOException
	 {
		
		    driver = InitializeDriver();
			Homepage = new HomePage(driver);
			Homepage.goTo();
			return Homepage;
		 
	 }	
	
	@AfterTest(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
}
