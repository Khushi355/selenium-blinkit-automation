import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:/sel_work/exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://blinkit.com/");
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement location = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Detect my location']")));
		location.click();

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector(".LocationDropDown__LocationOverlay-sc-bx29pc-1")));

		WebDriverWait waitTil = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement selectMenue = waitTil
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt = '3 - Fruits & Vegetables']")));
		selectMenue.click();

		// Add products with quantity using logic

		ArrayList<String> products = new ArrayList<>();
		products.add("Onion (Pyaz)");
		products.add("Broccoli");
		products.add("Green Chilli (Hari Mirch)");

		ArrayList<Integer> quantities = new ArrayList<>();
		quantities.add(3);
		quantities.add(2);
		quantities.add(4);

		for (int i = 0; i < products.size(); i++) {

			String itemName = products.get(i);
			int qty = quantities.get(i);

			// ADD button
			By addBtn = By.xpath("//div[contains(normalize-space(),'" + itemName
					+ "')]/ancestor::div[contains(@class,'tw-flex-col')]//div[normalize-space()='ADD']");
			System.out.println(addBtn);
			WebElement add = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
			add.click(); // quantity = 1

			// + button
			By plusBtn = By.xpath("//div[text()='" + itemName
					+ "']/ancestor::div[contains(@class,'tw-flex-col')]//button[.//span[contains(@class,'icon-plus')]]");
			

			// quantity increase
			for (int j = 1; j < qty; j++) {
				WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(plusBtn));
				plus.click();
				Thread.sleep(400);
			}
		}
// Add onion quantity 3 times using AI tool
		/*
		 * WebElement addItem =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//div[text()='Onion (Pyaz)']/ancestor::div[@class='tw-flex tw-w-full tw-flex-col']//div[text()='ADD']"
		 * ))); addItem.click();
		 * 
		 * // STEP 2: Click + button two times (to make quantity = * 3) By plusBtn =
		 * By.xpath(
		 * "//div[contains(.,'Onion')]/ancestor::div[contains(@class,'tw-flex-col')]//button[.//span[contains(@class,'icon-plus')]]"
		 * ); wait.until(ExpectedConditions.presenceOfElementLocated(plusBtn));
		 * 
		 * for (int i = 0; i < 2; i++) { WebElement plus =
		 * wait.until(ExpectedConditions.elementToBeClickable(plusBtn)); plus.click();
		 * Thread.sleep(500); // animation wait (important for Blinkit) }
		 */

	}

}
