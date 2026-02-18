package blinkit;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.io.FileUtils;

public class optionUse {

	public static void main(String[] args) throws IOException {

		
		  ChromeOptions options = new ChromeOptions();
		  options.setAcceptInsecureCerts(true); options.addArguments("--incognito");
		 

		System.setProperty("webdriver.chrome.driver", "F:/sel_work/exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//for ssl 
		 driver.get("https://expired.badssl.com/");
		  System.out.println(driver.getTitle());
		 
		
		//Viewport screenshot
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("F:\\sel_work\\screenshot.png"));

		// full page screenshot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG", new File("F:\\sel_work\\fullpage.png")
		);
	}
 
}
