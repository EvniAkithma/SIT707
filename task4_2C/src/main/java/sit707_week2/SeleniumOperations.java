package sit707_week2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ================= OFFICEWORKS =================
	public static void officeworks_registration_page(String url) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		sleep(2);

		driver.get(url);
		driver.manage().window().maximize();

		// First name
		driver.findElement(By.id("firstname")).sendKeys("Ahsan");

		// Last name
		driver.findElement(By.id("lastname")).sendKeys("Wanniarachchi");

		// Email
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");

		// Password (weak to trigger validation)
		driver.findElement(By.id("password")).sendKeys("123");

		// Confirm password
		driver.findElement(By.id("confirmPassword")).sendKeys("123");

		sleep(2);

		// Click Create Account
		driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();

		sleep(3);

		// Screenshot
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(src.toPath(), new File("officeworks.png").toPath(),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sleep(2);
		driver.quit();
	}

	// ================= SECOND WEBSITE =================
	public static void second_registration_page(String url) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		sleep(2);

		driver.get(url);
		driver.manage().window().maximize();

		// select male
		driver.findElement(By.id("male")).click();
		sleep(1);

		// first name
		WebElement fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("Ahsan");
		sleep(1);

		// last name
		WebElement lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("Wanniarachchi");
		sleep(1);

		// checkbox
		driver.findElement(By.id("newsletter")).click();
		sleep(2);

		// ⭐ TAKE SCREENSHOT BEFORE SUBMIT
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(src.toPath(), new File("second_site.png").toPath(),
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Second site screenshot saved.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		sleep(2);

		// submit AFTER screenshot
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		sleep(2);
		driver.quit();
	}
}