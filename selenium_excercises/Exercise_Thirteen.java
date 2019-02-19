package excercises;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

public class Exercise_Thirteen {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com/");
		
		// Find a Flight
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
		// Flight Details
		List<WebElement> tripTypeOptions = driver.findElements(By.name("tripType"));
		tripTypeOptions.get(0).click();
		
		Select passCountSelector = new Select(driver.findElement(By.name("passCount")));
		passCountSelector.selectByVisibleText("1");
		
		Select fromPortSelector = new Select(driver.findElement(By.name("fromPort")));
		fromPortSelector.selectByVisibleText("Paris");
		
		Select fromMonthSelector = new Select(driver.findElement(By.name("fromMonth")));
		fromMonthSelector.selectByVisibleText("April");
		
		Select fromDaySelector = new Select(driver.findElement(By.name("fromDay")));
		fromDaySelector.selectByVisibleText("27");
		
		Select toPortSelector = new Select(driver.findElement(By.name("toPort")));
		toPortSelector.selectByVisibleText("London");

		Select toMonthSelector = new Select(driver.findElement(By.name("toMonth")));
		toMonthSelector.selectByVisibleText("June");
		
		Select toDaySelector = new Select(driver.findElement(By.name("toDay")));
		toDaySelector.selectByVisibleText("30");
		
		// Preferences
		List<WebElement> servClassOptions = driver.findElements(By.name("servClass"));
		servClassOptions.get(2).click();
		
		Select airlineSelector = new Select(driver.findElement(By.name("airline")));
		airlineSelector.selectByVisibleText("Unified Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		// Select Flight
		List<WebElement> outFlightOptions = driver.findElements(By.name("outFlight"));
		outFlightOptions.get(2).click();
		
		List<WebElement> inFlightOptions = driver.findElements(By.name("inFlight"));
		inFlightOptions.get(3).click();
		
		driver.findElement(By.name("reserveFlights")).click();
		
		// Select Flight
		driver.findElement(By.name("passFirst0")).sendKeys("Juan");
		driver.findElement(By.name("passLast0")).sendKeys("Alvarez");
		
		Select passMealSelector = new Select(driver.findElement(By.name("pass.0.meal")));
		passMealSelector.selectByVisibleText("Kosher");
		
		// Credit Card
		Select creditCardSelector = new Select(driver.findElement(By.name("creditCard")));
		creditCardSelector.selectByVisibleText("Discover");
		
		driver.findElement(By.name("creditnumber")).sendKeys("1234432112344321");
		
		Select creditCardExpMonthSelector = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
		creditCardExpMonthSelector.selectByVisibleText("05");
		
		Select creditCardExpYearSelector = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
		creditCardExpYearSelector.selectByVisibleText("2010");
			
		driver.findElement(By.name("cc_frst_name")).sendKeys("Juan");
		driver.findElement(By.name("cc_mid_name")).sendKeys("Manuel");
		driver.findElement(By.name("cc_last_name")).sendKeys("Alvarez");
		
		// Billing Address
		driver.findElement(By.name("billAddress1")).clear();
		driver.findElement(By.name("billAddress1")).sendKeys("Address 1 Address 1");
		
		driver.findElement(By.name("billCity")).clear();
		driver.findElement(By.name("billCity")).sendKeys("Cancun");
		
		driver.findElement(By.name("billState")).clear();
		driver.findElement(By.name("billState")).sendKeys("Quintana Roo");
		
		driver.findElement(By.name("billZip")).clear();
		driver.findElement(By.name("billZip")).sendKeys("77533");
		
		Select billCountrySelector = new Select(driver.findElement(By.name("billCountry")));
		billCountrySelector.selectByVisibleText("MEXICO");
		
		// Delivery Address
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")).click();
		driver.findElement(By.name("buyFlights")).click();
		Thread.sleep(2000);
		
		// Confirmation
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/a")).click();
		
		Thread.sleep(5000);
		driver.close();
	}	
}