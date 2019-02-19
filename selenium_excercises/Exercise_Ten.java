package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import java.util.ArrayList;
	import java.util.concurrent.TimeUnit;

public class Exercise_Ten {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows");
		
		System.out.println("Window Name: " + driver.getWindowHandle());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();		
		
		System.out.println("All Windows Names: " + driver.getWindowHandles());
		
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		driver.close();
	}
}