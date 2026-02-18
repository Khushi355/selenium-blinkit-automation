package blinkit;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionUse {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:/sel_work/exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions mouseHover = new Actions(driver);

		// Mouse hover on specific element
		WebElement move = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Hello, sign in']/ancestor::a")));
		mouseHover.moveToElement(move).build().perform();

		// Mouse click and type in caps
		WebElement typeCaps = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		mouseHover.moveToElement(typeCaps).click().keyDown(Keys.SHIFT).sendKeys("hair").build().perform();
		typeCaps.click();
		typeCaps.sendKeys(Keys.CONTROL, "a");
		typeCaps.sendKeys(Keys.DELETE);

		// get all link from footer (Lecture96)
		WebElement footerDriver = driver.findElement(By.id("navFooter"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		for (int i = 1; i < footerDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
		}

		// right click logic

		WebElement rightClick = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#nav-orders")));
		mouseHover.moveToElement(rightClick).contextClick().build().perform();

	}

}
