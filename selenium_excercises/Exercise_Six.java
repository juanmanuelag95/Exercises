package excercises;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

public class Exercise_Six {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		Select continentsSelector = new Select(driver.findElement(By.id("continents")));
		// select by index
		continentsSelector.selectByIndex(1);
		
		// select by selectByVisibleText
		continentsSelector.selectByVisibleText("Africa");
		
		// all options from the select
		List<WebElement> continentsOptions = continentsSelector.getOptions();
		String continentSelect = "North America";
		
		for (int i = 0; i < continentsOptions.size(); i++) {
			// print all options
			String continentText = continentsOptions.get(i).getText();
			System.out.println(continentText);
			
			// select option given by user
			if (continentSelect.equals(continentText)) 
				continentsSelector.selectByIndex(i);
		}
		driver.close();
	}
}