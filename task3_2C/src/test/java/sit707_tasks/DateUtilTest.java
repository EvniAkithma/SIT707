package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
 * Modified by Evni Akithma Wanniarachchi Kankanamge
 */
public class DateUtilTest {
	
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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        int originalDay = date.getDay();
        date.increment();
        System.out.println(date);

        if (originalDay < 31) {
        	Assert.assertEquals(originalDay + 1, date.getDay());
        	Assert.assertEquals(1, date.getMonth());
        } else {
        	Assert.assertEquals(1, date.getDay());
        	Assert.assertEquals(2, date.getMonth());
        }
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// ---------- February (Leap Year) ----------
	
	@Test
	public void testMaxFebruary29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("testMaxFebruary29ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxFebruary29ShouldDecrementToFebruary28() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("testMaxFebruary29ShouldDecrementToFebruary28 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinFebruary1ShouldIncrementToFebruary2() {
		DateUtil date = new DateUtil(1, 2, 2024);
		System.out.println("testMinFebruary1ShouldIncrementToFebruary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinFebruary1ShouldDecrementToJanuary31() {
		DateUtil date = new DateUtil(1, 2, 2024);
		System.out.println("testMinFebruary1ShouldDecrementToJanuary31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFebruary28ShouldIncrementToFebruary29() {
		DateUtil date = new DateUtil(28, 2, 2024);
		System.out.println("testLeapYearFebruary28ShouldIncrementToFebruary29 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFebruary29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("testLeapYearFebruary29ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	// ---------- March ----------
	
	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}
	
	@Test
	public void testMinMarch1ShouldDecrementToFebruary29() {
		DateUtil date = new DateUtil(1, 3, 2024);
		date.decrement();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}
	
	// ---------- April ----------
	
	@Test
	public void testMaxApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testMinApril1ShouldDecrementToMarch31() {
		DateUtil date = new DateUtil(1, 4, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}
	
	// ---------- May ----------
	
	@Test
	public void testMaxMay31ShouldIncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(6, date.getMonth());
	}
	
	@Test
	public void testMinMay1ShouldDecrementToApril30() {
		DateUtil date = new DateUtil(1, 5, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}
	
	// ---------- June ----------
	
	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
	}
	
	@Test
	public void testMinJune1ShouldDecrementToMay31() {
		DateUtil date = new DateUtil(1, 6, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}
	
	// ---------- July ----------
	
	@Test
	public void testMaxJuly31ShouldIncrementToAugust1() {
		DateUtil date = new DateUtil(31, 7, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(8, date.getMonth());
	}
	
	@Test
	public void testMinJuly1ShouldDecrementToJune30() {
		DateUtil date = new DateUtil(1, 7, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(6, date.getMonth());
	}
	
	// ---------- August ----------
	
	@Test
	public void testMaxAugust31ShouldIncrementToSeptember1() {
		DateUtil date = new DateUtil(31, 8, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(9, date.getMonth());
	}
	
	@Test
	public void testMinAugust1ShouldDecrementToJuly31() {
		DateUtil date = new DateUtil(1, 8, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(7, date.getMonth());
	}
	
	// ---------- September ----------
	
	@Test
	public void testMaxSeptember30ShouldIncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(10, date.getMonth());
	}
	
	@Test
	public void testMinSeptember1ShouldDecrementToAugust31() {
		DateUtil date = new DateUtil(1, 9, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(8, date.getMonth());
	}
	
	// ---------- October ----------
	
	@Test
	public void testMaxOctober31ShouldIncrementToNovember1() {
		DateUtil date = new DateUtil(31, 10, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(11, date.getMonth());
	}
	
	@Test
	public void testMinOctober1ShouldDecrementToSeptember30() {
		DateUtil date = new DateUtil(1, 10, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(9, date.getMonth());
	}
	
	// ---------- November ----------
	
	@Test
	public void testMaxNovember30ShouldIncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}
	
	@Test
	public void testMinNovember1ShouldDecrementToOctober31() {
		DateUtil date = new DateUtil(1, 11, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(10, date.getMonth());
	}
	
	// ---------- December ----------
	
	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
		DateUtil date = new DateUtil(1, 12, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(11, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	// ---------- Extra invalid date checks ----------
	
	@Test(expected = RuntimeException.class)
	public void testInvalidJune31ShouldThrowException() {
		new DateUtil(31, 6, 2024);
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidFebruary30ShouldThrowException() {
		new DateUtil(30, 2, 2024);
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidMonthShouldThrowException() {
		new DateUtil(15, 13, 2024);
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidDayShouldThrowException() {
		new DateUtil(0, 5, 2024);
	}
	
	// ===============================
	// EQUIVALENCE CLASS TESTS (3.2C)
	// ===============================
	
	// D1: day between 1–28
	@Test
	public void testEquivalenceClassDayBetween1And28() {
		DateUtil date = new DateUtil(15, 1, 2023);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// D2: day = 29 in leap-year February
	@Test
	public void testEquivalenceClassDay29LeapYearFebruary() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	// D3: day = 30 in a 30-day month
	@Test
	public void testEquivalenceClassDay30InThirtyDayMonth() {
		DateUtil date = new DateUtil(30, 4, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// D4: day = 31 in a 31-day month
	@Test
	public void testEquivalenceClassDay31InThirtyOneDayMonth() {
		DateUtil date = new DateUtil(31, 1, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// February in non-leap year
	@Test
	public void testEquivalenceClassFebruaryNonLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	// Year equivalence: leap year vs non-leap year
	@Test
	public void testEquivalenceClassLeapYearVsNonLeapYear() {
		DateUtil leapYearDate = new DateUtil(28, 2, 2024);
		leapYearDate.increment();
		Assert.assertEquals(29, leapYearDate.getDay());
		Assert.assertEquals(2, leapYearDate.getMonth());
		Assert.assertEquals(2024, leapYearDate.getYear());

		DateUtil nonLeapYearDate = new DateUtil(28, 2, 2023);
		nonLeapYearDate.increment();
		Assert.assertEquals(1, nonLeapYearDate.getDay());
		Assert.assertEquals(3, nonLeapYearDate.getMonth());
		Assert.assertEquals(2023, nonLeapYearDate.getYear());
	}
}