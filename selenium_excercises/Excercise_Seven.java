package excercises;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

public class Excercise_Seven {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		Select seleniumCommandsSelector = new Select(driver.findElement(By.name("selenium_commands")));
		// select by index
		seleniumCommandsSelector.selectByIndex(0);
		seleniumCommandsSelector.deselectByIndex(0);
		
		// select by selectByVisibleText
		seleniumCommandsSelector.selectByVisibleText("Navigation Commands");
		seleniumCommandsSelector.selectByVisibleText("Navigation Commands");
		
		// all options from the select
		List<WebElement> commandsOptions = seleniumCommandsSelector.getOptions();
		
		// select and print all options
		for (int i = 0; i < commandsOptions.size(); i++) {
			System.out.println(commandsOptions.get(i).getText());
			seleniumCommandsSelector.selectByIndex(i);
		}
		
		// deselect all options
		seleniumCommandsSelector.deselectAll();
		driver.close();
	}	
}