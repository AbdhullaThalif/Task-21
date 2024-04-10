package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_21_1 {
	
 public static void main(String[] args) throws Exception {
		 
	      // Launch the ChromeDriver browser
		  WebDriver driver = new ChromeDriver();
	      // Navigate to the Herokuapp.com URL
	      driver.get("https://the-internet.herokuapp.com/iframe");
	      driver.manage().window().maximize();  
	      //  Switch to the iframe
	      WebElement e = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
	      driver.switchTo().frame(e);
	      Thread.sleep(1000);
	      // Input the text in the "p" tag
	      driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Hello People");
	      driver.quit();
 }

}
