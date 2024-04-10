package task;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_21_2 {

	public static void main(String[] args) {

		// Launch the ChromeDriver browser
		WebDriver driver = new ChromeDriver();
		// Navigate to the Herokuapp.com windows URL
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		// Click the "Click Here" button
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		// Switch to the newly opened window
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		// Confirm the New window present on the page
		WebElement x = driver.findElement(By.xpath("/html/body/div/h3"));
		String a = x.getText();
		System.out.println(a);
		if (a.equalsIgnoreCase("New Window")) {
			System.out.println("Is present the page");
		} else {
			System.out.println("Is not present the page");
		}
		// Close the new window
		driver.close();
		// Switch to the original window
		driver.switchTo().window(mainWindowHandle);
		// Confirm the original window is active
		String y = driver.getTitle();
		System.out.println(y);
		if (y.equalsIgnoreCase("The Internet")) {
			System.out.println("Original window is Active");
		} else {
			System.out.println("Original window is Inactive");
		}
		// Close the browser
		driver.quit();
	}

}
