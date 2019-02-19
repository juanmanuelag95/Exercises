package excercises;
	import java.util.List;
//	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Exercise_Five {
		public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		// CHALLENGE ONE
		List<WebElement> botonSexOptions = driver.findElements(By.name("sex"));
		
		// check if first is selected
		if (botonSexOptions.get(0).isSelected()) 
			// select second
			botonSexOptions.get(1).click();
		else
			// select first
			botonSexOptions.get(0).click();
		
		// CHALLENGE TWO
		driver.findElement(By.id("exp-2")).click();
		
		// CHALLENGE THREE
		List<WebElement> checkProfessionsOptions = driver.findElements(By.name("profession"));
		String valueToTest = "Automation Tester";
		for (int i = 0; i < checkProfessionsOptions.size(); i++) 
			if (valueToTest.equals(checkProfessionsOptions.get(i).getAttribute("value")) ) 
				checkProfessionsOptions.get(i).click();
		
		// CHALLENGE FOUR
		driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();
		
		driver.close();
	}
}