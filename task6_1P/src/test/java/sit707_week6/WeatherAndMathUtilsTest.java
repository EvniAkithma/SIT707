package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "224323742";
		Assert.assertNotNull("Student ID is null", studentId);
		Assert.assertEquals("224323742", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Evni Akithma Wanniarachchi Kankanamge";
		Assert.assertNotNull("Student name is null", studentName);
		Assert.assertEquals("Evni Akithma Wanniarachchi Kankanamge", studentName);
	}

	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(2));
		Assert.assertTrue(WeatherAndMathUtils.isEven(100));
		Assert.assertTrue(WeatherAndMathUtils.isEven(0));
	}

	@Test
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(1));
		Assert.assertFalse(WeatherAndMathUtils.isEven(7));
		Assert.assertFalse(WeatherAndMathUtils.isEven(99));
	}

	@Test
	public void testPrimeNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
		Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}

	@Test
	public void testNonPrimeNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
		Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
		Assert.assertFalse(WeatherAndMathUtils.isPrime(10));
	}

	@Test
	public void testOneIsPrime() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
	}

	@Test
	public void testCancelWeatherAdviceByWind() {
		Assert.assertEquals("CANCEL",
				WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}

	@Test
	public void testCancelWeatherAdviceByRain() {
		Assert.assertEquals("CANCEL",
				WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
	}

	@Test
	public void testCancelWeatherAdviceByCombinedCondition() {
		Assert.assertEquals("CANCEL",
				WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
	}

	@Test
	public void testWarnWeatherAdviceByWind() {
		Assert.assertEquals("WARN",
				WeatherAndMathUtils.weatherAdvice(50.0, 0.0));
	}

	@Test
	public void testWarnWeatherAdviceByRain() {
		Assert.assertEquals("WARN",
				WeatherAndMathUtils.weatherAdvice(0.0, 5.0));
	}

	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR",
				WeatherAndMathUtils.weatherAdvice(20.0, 1.0));
	}
}
