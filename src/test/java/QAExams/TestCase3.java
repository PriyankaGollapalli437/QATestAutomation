package QAExams;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> result = driver.findElements(By.cssSelector("img[class='s-image']"));
		result.get(0).click();
		//driver.findElement(By.cssSelector("img[alt*='Lenovo Tab M8 Tablet']")).click();
		driver.findElement(By.cssSelector("span[id='submit.add-to-cart']")).click();
		driver.findElement(By.cssSelector("span[id='sw-gtc']")).click();
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
		driver.findElement(By.xpath("//h1[@class='a-spacing-small'][1]")).isDisplayed();
		Assert.assertTrue(true);
		
		
		
		
		
	}

}
