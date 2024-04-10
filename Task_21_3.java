package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_21_3 {
	public static void main(String[] args) {

		// Launch the ChromeDriver browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Switch to the top frame
		WebElement top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(top);
		// Confirm to be there are three frames on the page
		List<WebElement> elements = driver.findElements(By.tagName("frame"));
		System.out.println(elements.size());

		// Switch to the left frame
		WebElement left = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(left);
		// Confirm the left frame has a text "LEFT"
		String frametext = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(frametext);

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Switch to the middle frame
		WebElement middle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middle);
		// Confirm the middle frame has a text "MIDDLE"
		String frametext1 = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(frametext1);

		// Switch back to the top frame
		driver.switchTo().parentFrame();

		// Switch to the right frame
		WebElement right = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(right);
		// Confirm the right frame has a text "RIGHT"
		String frametext2 = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(frametext2);
		
		// Switch back to the top frame
		driver.switchTo().defaultContent();

		// Switch to the bottom frame
		WebElement bottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottom);
		// Confirm the bottom frame has a text "BOTTOM"
		String frametext3 = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(frametext3);
		
		// Switch back to the top frame
		driver.switchTo().defaultContent();
		WebElement top1 = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(top1);
		// Confirm the page is frames
		String title1 = driver.getCurrentUrl();
		System.out.println(title1);
		if (title1.contains("frames")) {
			System.out.println("Frames");
		} else {
			System.out.println("Its Not Frames");
		}

	}
}
