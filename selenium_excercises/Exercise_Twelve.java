package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

public class Exercise_Twelve {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com/");
		driver.findElement(By.partialLinkText("REGISTER")).click();
		
		// Contact Information
		driver.findElement(By.name("firstName")).sendKeys("Juan");
		driver.findElement(By.name("lastName")).sendKeys("Alvarez");
		driver.findElement(By.name("phone")).sendKeys("0987654321");
		driver.findElement(By.name("userName")).sendKeys("juanmanuel@test.com");
		
		// Mailing Information
		driver.findElement(By.name("address1")).sendKeys("Address 1 Address 1");
		driver.findElement(By.name("address2")).sendKeys("Address 2 Address 2");
		driver.findElement(By.name("city")).sendKeys("Cancun");
		driver.findElement(By.name("state")).sendKeys("Quintana Roo");
		driver.findElement(By.name("postalCode")).sendKeys("77553");
		Select countrySelector = new Select(driver.findElement(By.name("country")));
		countrySelector.selectByVisibleText("MEXICO");
		
		// User Information
		driver.findElement(By.name("email")).sendKeys("juanmanuelag95");
		driver.findElement(By.name("password")).sendKeys("password1");
		driver.findElement(By.name("confirmPassword")).sendKeys("password1");
		driver.findElement(By.name("register")).click();
		
		// User Validation
		if (driver.getCurrentUrl().equals("http://newtours.demoaut.com/create_account_success.php"))
			System.out.println("Register correct");
		else
			System.out.println("Register incorrect" + driver.getCurrentUrl());
		
		Thread.sleep(5000);
		driver.close();
	}

}
