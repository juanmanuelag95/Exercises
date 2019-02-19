package excercises;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise_Nine {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		
		String rowDubai = "1";
		String colDubai = "2";
		System.out.println(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + rowDubai + "]/td[" + colDubai + "]")).getText());
		String valueToTest = "Clock Tower Hotel";
		
		for (int i = 1; i <= 5; i++)
				if (valueToTest.equals(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText()))
					for (int j = 1; j <= 5; j++)
						System.out.println(driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText());					
		driver.close();
	}
}