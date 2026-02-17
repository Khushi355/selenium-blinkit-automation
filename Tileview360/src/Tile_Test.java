import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tile_Test {

	public static void main(String[] args) throws InterruptedException {

		// invoking browser chrome
		System.setProperty("webdriver.chrome.driver", "F:/sel_work/exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Thread.sleep(2000);
		driver.get("https://srijanx.com");
		System.out.println(driver.getTitle());

		// create a wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div/button[2]")).click();

		// WAIT until email field is ready
		WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("email-input")));
		emailInput.sendKeys("dali12@gmail.com");

		// wait untill password field is ready
		WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-input")));
		passwordInput.sendKeys("rHP5I944$ja2");

		// driver.findElement(By.className("w-full")).click();
		WebElement signInBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.touch-manipulation.w-full")));
		signInBtn.click();

		/*
		 * WebElement myTileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[normalize-space()='My Tiles']"))); myTileBtn.click();
		 */
		/*
		 * WebElement btn =
		 * driver.findElement(By.xpath("//button[normalize-space()='My Tiles']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		 * Thread.sleep(500); // small wait for layout adjustment btn.click();
		 */
		WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement tileBtn = longWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add New Tile')]")));
		tileBtn.click();

		// button[normalize-space()='Add New Tile']
		// seller - new tile add

		WebElement tileName = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Enter tile name']")));
		tileName.sendKeys("DaliAutoTest");

		WebElement tileCode = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input[placeholder='Auto-generated if empty']")));
		tileCode.sendKeys("T-0978");

		// Wait until dropdown is present
		WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//label[normalize-space()='Category *']/following-sibling::select")));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("wall");

		// for link= driver.findElement(By.linkText("link text type here")).click();

		// driver.close();

	}

}
