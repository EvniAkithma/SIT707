package sit707_week4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BunningsLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://www.bunnings.com.au/login";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    private void openLoginPage() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.urlContains("login"));
    }

    private void closePopupIfPresent() {
        try {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement btn : buttons) {
                String text = btn.getText().trim().toLowerCase();
                String aria = btn.getAttribute("aria-label");
                if (aria == null) aria = "";
                aria = aria.toLowerCase();

                if (text.contains("accept") || text.contains("agree") || text.contains("got it")
                        || aria.contains("close")) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
                        Thread.sleep(1000);
                        break;
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private WebElement getEmailField() {
        List<By> possibleLocators = List.of(
                By.id("username"),
                By.name("username"),
                By.id("email"),
                By.name("email"),
                By.cssSelector("input[type='email']"),
                By.cssSelector("input[autocomplete='username']"),
                By.xpath("//input[contains(@placeholder,'Email')]"),
                By.xpath("//input[contains(@placeholder,'email')]")
        );

        for (By locator : possibleLocators) {
            try {
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (el.isDisplayed()) {
                    return el;
                }
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("Email field not found");
    }

    private WebElement getPasswordField() {
        List<By> possibleLocators = List.of(
                By.id("password"),
                By.name("password"),
                By.cssSelector("input[type='password']"),
                By.cssSelector("input[autocomplete='current-password']"),
                By.xpath("//input[contains(@placeholder,'Password')]"),
                By.xpath("//input[contains(@placeholder,'password')]")
        );

        for (By locator : possibleLocators) {
            try {
                WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                if (el.isDisplayed()) {
                    return el;
                }
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("Password field not found");
    }

    private WebElement getLoginButton() {
        List<By> possibleLocators = List.of(
                By.cssSelector("button[type='submit']"),
                By.xpath("//button[contains(.,'Sign in')]"),
                By.xpath("//button[contains(.,'Log in')]"),
                By.xpath("//button[contains(.,'Login')]"),
                By.xpath("//input[@type='submit']")
        );

        for (By locator : possibleLocators) {
            try {
                WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
                if (el.isDisplayed()) {
                    return el;
                }
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("Login button not found");
    }

    private void safeType(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + text + "';", element);
        }
    }

    private void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224323742";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Evni Akithma Wanniarachchi Kankanamge";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testLoginEmptyEmailEmptyPassword() {
        openLoginPage();
        closePopupIfPresent();

        safeClick(getLoginButton());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Should stay on login page", currentUrl.contains("login"));
    }

    @Test
    public void testLoginEmptyEmailPasswordOnly() {
        openLoginPage();
        closePopupIfPresent();

        safeType(getPasswordField(), "Password123!");
        safeClick(getLoginButton());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Should stay on login page", currentUrl.contains("login"));
    }

    @Test
    public void testLoginEmailOnly() {
        openLoginPage();
        closePopupIfPresent();

        safeType(getEmailField(), "test@email.com");
        safeClick(getLoginButton());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Should stay on login page", currentUrl.contains("login"));
    }

    @Test
    public void testLoginInvalidCredentials() {
        openLoginPage();
        closePopupIfPresent();

        safeType(getEmailField(), "wrong@email.com");
        safeType(getPasswordField(), "wrongpassword123");
        safeClick(getLoginButton());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Should stay on login page for invalid credentials",
                currentUrl.contains("login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}