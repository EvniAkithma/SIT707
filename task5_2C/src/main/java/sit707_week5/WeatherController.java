package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class WeatherController {

	public static final int HOURS_PER_DAY = 3;

	private static WeatherController instance;

	// fake clock support for repeatable testing
	private Date currentDate = null;

	/**
	 * Factory method for single instance WeatherController.
	 * @return
	 */
	public static WeatherController getInstance() {
		if (instance == null) {
			instance = new WeatherController();
		}
		return instance;
	}

	// Initialise hourly temperature
	private static double[] todaysHourlyTemperature = new double[HOURS_PER_DAY];

	/**
	 * Private constructor prevents creating new instance manually.
	 */
	private WeatherController() {
		System.out.println("Creating new weather controller.");

		// sleep a while to simulate a delay
		sleep(2 + new Random().nextInt(5));

		// Insert random temperature values
		Random random = new Random();
		for (int i = 0; i < HOURS_PER_DAY; i++) {
			todaysHourlyTemperature[i] = 1 + random.nextInt(30);
		}
		System.out.println(Arrays.toString(todaysHourlyTemperature));
	}

	public void close() {
		System.out.println("Closing weather controller.");
		instance = null;

		// sleep a while to simulate a delay
		sleep(2 + new Random().nextInt(5));
	}

	/**
	 * Set fake date for repeatable testing.
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * Calculate minimum temperature.
	 */
	public double getTemperatureMinFromCache() {
		double minVal = 1000;
		for (int i = 0; i < todaysHourlyTemperature.length; i++) {
			if (minVal > todaysHourlyTemperature[i]) {
				minVal = todaysHourlyTemperature[i];
			}
		}
		return minVal;
	}

	/**
	 * Calculate maximum temperature.
	 */
	public double getTemperatureMaxFromCache() {
		double maxVal = -1;
		for (int i = 0; i < todaysHourlyTemperature.length; i++) {
			if (maxVal < todaysHourlyTemperature[i]) {
				maxVal = todaysHourlyTemperature[i];
			}
		}
		return maxVal;
	}

	/**
	 * Calculate average temperature.
	 */
	public double getTemperatureAverageFromCache() {
		double sumVal = 0;
		for (int i = 0; i < todaysHourlyTemperature.length; i++) {
			sumVal += todaysHourlyTemperature[i];
		}
		return sumVal / todaysHourlyTemperature.length;
	}

	/**
	 * Return temperature for given hour.
	 */
	public double getTemperatureForHour(int hour) {
		// sleep a while to simulate a delay
		sleep(1 + new Random().nextInt(5));

		if (hour > todaysHourlyTemperature.length) {
			hour = 1 + new Random().nextInt(todaysHourlyTemperature.length);
		}

		return todaysHourlyTemperature[hour - 1];
	}

	/**
	 * Persist temperature and return saved time.
	 */
	public String persistTemperature(int hour, double temperature) {
		SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");

		Date dateToUse = (currentDate != null) ? currentDate : new Date();
		String savedTime = sdf.format(dateToUse);

		System.out.println(
				"Temperature: " + temperature + " of hour: " + hour + ", saved at " + savedTime);

		// sleep a while to simulate delay
		sleep(1 + new Random().nextInt(2));

		return savedTime;
	}

	/**
	 * Return total hours.
	 */
	public int getTotalHours() {
		return todaysHourlyTemperature.length;
	}

	/**
	 * Sleep for specified seconds.
	 */
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
