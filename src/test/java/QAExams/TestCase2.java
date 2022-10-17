package QAExams;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String category = "Electronics";
		String product = "iPhone 14";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select selects = new Select(driver.findElement(By.cssSelector("select[class*='nav-search-dropdown']")));
		selects.getOptions().stream().filter(cat-> cat.getText().contains(category)).findFirst().get().click();
		WebElement e = driver.findElement(By.xpath("//input[@name='field-keywords']"));
		e.sendKeys(product);
		e.sendKeys(Keys.RETURN);
		
		driver.findElement(By.cssSelector("li[id='p_36/1253506011'] span[class*='a-size-base']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='a-popover-inner']")));
		driver.findElement(By.cssSelector("span[class='a-dropdown-container'] span[class='a-button-inner']")).click();
		driver.findElement(By.cssSelector("div[class='a-popover-inner'] li[role='option']:nth-child(3)")).click();
		
		List<WebElement> Prices = driver.findElements(By.cssSelector(".a-price-whole"));
		List<String> Items = new ArrayList<String>();
		
		for(WebElement p : Prices) {
			Items.add(p.getText());
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String NextButton = driver.findElement(By.cssSelector(".s-pagination-next")).getAttribute("class");
		
		
		while(!NextButton.contains("disabled"))
		{
			
			
			driver.findElement(By.cssSelector(".s-pagination-next")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Prices = driver.findElements(By.cssSelector(".a-price-whole"));
			
			for(WebElement p : Prices)
			{
				Items.add(p.getText());
				
			}
			NextButton = driver.findElement(By.cssSelector(".s-pagination-next")).getAttribute("class");
		}
			
			
		
		List<Integer> Numbers = new ArrayList<Integer>(Items.size());
		for(String current:Items){
		  Numbers.add(Integer.parseInt(current));
		}
		
		
		//System.out.println(Numbers);
		
		System.out.println(Numbers.size());
		
		
		for(int j=0; j<=Numbers.size()-1; j++)
		{
			//System.out.println(Numbers.indexOf(i));
			
			
		if(Numbers.get(j)>=Numbers.get(j+1)) {
		
			//Assert.assertTrue(true);
			System.out.println("Descending order");
		
		}
		else
			
		{
			System.out.println("Not in Descending order");
			
		}
		}
		
	
		
		}
            
            
            
   
            
            
     
		
		
		
	}	
			
	
		
		
		
		
	


