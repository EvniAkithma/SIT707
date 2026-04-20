package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static double[] hourlyTemperatures;
	private static int nHours;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("+++ Initialising WeatherController once for all tests +++");

		// Arrange: initialise controller only once
		wController = WeatherController.getInstance();
		nHours = wController.getTotalHours();
		hourlyTemperatures = new double[nHours];

		// Arrange: retrieve slow temperature values once and store locally
		for (int i = 0; i < nHours; i++) {
			hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("+++ Closing WeatherController after all tests +++");

		if (wController != null) {
			wController.close();
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
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		// Arrange
		double minTemperature = hourlyTemperatures[0];

		// Act
		for (int i = 1; i < nHours; i++) {
			if (minTemperature > hourlyTemperatures[i]) {
				minTemperature = hourlyTemperatures[i];
			}
		}

		// Assert
		Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.0001);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		// Arrange
		double maxTemperature = hourlyTemperatures[0];

		// Act
		for (int i = 1; i < nHours; i++) {
			if (maxTemperature < hourlyTemperatures[i]) {
				maxTemperature = hourlyTemperatures[i];
			}
		}

		// Assert
		Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.0001);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		// Arrange
		double sumTemp = 0;

		// Act
		for (int i = 0; i < nHours; i++) {
			sumTemp += hourlyTemperatures[i];
		}
		double averageTemp = sumTemp / nHours;

		// Assert
		Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.0001);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}