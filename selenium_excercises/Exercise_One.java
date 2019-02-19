package excercises;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
public class Exercise_One {
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();
		
		// url of the site
		String url = "http://www.store.demoqa.com/";
		driver.get(url);
		String title = driver.getTitle();
		
		System.out.println("Title of the page: " + title);
		System.out.println("Length of the title: "+ title.length());
		
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equals(url)){
			System.out.println("The correct Url is opened.");
		}else{
			System.out.println("An incorrect Url is opened.");
			
			//In case of Fail, you like to print the actual and expected URL for the record purpose
			System.out.println("Actual URL: " + actualUrl);
			System.out.println("Expected URL: " + url);
		}
		
		// lenght of the page source
		System.out.println("Total length of the Pgae Source is : " + driver.getPageSource().length());
		
		driver.close();
	}
}