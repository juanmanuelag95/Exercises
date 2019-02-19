package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	
public class Exercise_Three {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.findElement(By.name("firstname")).sendKeys("Juan");
		driver.findElement(By.name("lastname")).sendKeys("Alvarez");
		driver.findElement(By.id("submit")).click();
		driver.close();
	}	
}