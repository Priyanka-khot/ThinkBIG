package Think;

	import static org.testng.Assert.assertEquals;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class ThinkBridge {

		WebDriver driver;
		
		@BeforeTest
		public void setUp99Page()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Driver\\chromedriver_win32\\chromedriver.exe");
			driver = (WebDriver) new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://phptravel.net");
		}
		//div[@class='chosen-container chosen-container-single chosen-container-single-nosearch chosen-container-active chosen-with-drop']
		@Test(priority=1)
		public void FlightSearch()
		{
			String Actualsearch = "22 Total listings found" ;
			driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
			//Click On Round Trip
			driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
			//Select Business Class
			driver.findElement(By.xpath("//span[contains(text(),'Economy')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Economy')]")).sendKeys(Keys.UP, Keys.ENTER);
			// Enter From Pune TO Nagpur
			driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys("Pune", Keys.TAB, "Nagpur", Keys.ENTER);
			
			driver.findElement(By.xpath("//*[@id=\"FlightsDateStart\"]")).click(); //Depart
	        //select depart date 1june 2020
			Actions a= new Actions(driver);
	        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div[2]"))).build().perform();
	        driver.findElement(By.xpath("//*[@id=\"FlightsDateEnd\"]")).click();
	        //select return date 6june2020
	        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div[7]"))).build().perform();
	        
	        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/span/button[1]"))).click().perform();
	        
	        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/span/button[1]"))).click().perform();
	        
	        a.moveToElement(driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[3]/div/div[2]/div/span/button[1]"))).click().perform();
		
	        driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button")).click();
	        

	        //assert.assertEquals(Actualsearch, "22 Total listings found");
		}

		
		@AfterTest
		public void closeConnection()
		{
			driver.quit();
		}
		
	}





