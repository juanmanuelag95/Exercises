package excercises;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import java.util.concurrent.TimeUnit;

public class Exercise_Eleven {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows");
		
		System.out.println("Window Name: " + driver.getWindowHandle());
		Thread.sleep(5000);
		driver.findElement(By.id("alert")).click();		
		
		Thread.sleep(2000);
		Alert alertWindow = driver.switchTo().alert();
		alertWindow.accept();
    	Thread.sleep(2000);
    	driver.close();
	}
}