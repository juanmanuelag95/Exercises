package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise_Eight {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")).getText());
		driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[6]/a")).click();
		driver.close();
	}
}