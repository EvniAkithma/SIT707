package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String submitLogin(String username, String password, String dob) {

		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
		);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/ASUS/Desktop/Java_Projects/task7_1P/pages/login.html"
		);

		sleep(2);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);

		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys(dob);

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(2);

		String title = driver.getTitle();

		driver.close();

		return title;
	}

	@Test
	public void testLoginSuccess() {
		Assert.assertEquals(
				"success",
				submitLogin("ahsan", "ahsan_pass", "01011990"));
	}

	@Test
	public void testWrongUsername() {
		Assert.assertEquals(
				"fail",
				submitLogin("wrong", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testWrongPassword() {
		Assert.assertEquals(
				"fail",
				submitLogin("ahsan", "wrong", "1990-01-01"));
	}

	@Test
	public void testWrongDob() {
		Assert.assertEquals(
				"fail",
				submitLogin("ahsan", "ahsan_pass", "02012000"));
	}

	@Test
	public void testEmptyFields() {
		Assert.assertEquals(
				"fail",
				submitLogin("", "", ""));
	}
}