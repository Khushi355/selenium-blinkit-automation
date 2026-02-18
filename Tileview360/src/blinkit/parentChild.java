package blinkit;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parentChild {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:/sel_work/exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		System.out.println(driver.getTitle());

		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		  Actions mouseHover = new Actions(driver);
		  
		  // Move parent to child window
		  
		  WebElement parentToChild = wait  .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[target='_blank']"))); parentToChild.click();
		  Set<String> windows = driver.getWindowHandles(); Iterator<String> go =
		  windows.iterator(); String parentId = go.next(); String childId = go.next();
		  driver.switchTo().window(childId);
		  
		  // getText from child window
		  
		  String text =
		  driver.findElement(By.xpath("//h1[text()=\"Learn to Code\"]")).getText(); 
		  if (text.contains("to")) 
		  {
			  System.out.println(text.split("to")[0]); 
		  } 
		    else
			    {  
			       System.out.println(text); 
			    }
	        	   driver.switchTo().window(parentId);
	        	 
	}

}
