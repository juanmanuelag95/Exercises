package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise_Four {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial test Complete");
		System.out.println(driver.findElement(By.tagName("button")).toString());
		
		driver.findElement(By.linkText("Link Test")).click();
		System.out.println("Link test Complete");
		driver.close();
	}
}