package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

	@Test
	public void testSumNumbers1() {
		Assert.assertEquals(1, LoopUtils.sumNumbers(1));
	}

	@Test
	public void testSumNumbers5() {
		Assert.assertEquals(15, LoopUtils.sumNumbers(5));
	}

	@Test
	public void testSumNumbers10() {
		Assert.assertEquals(55, LoopUtils.sumNumbers(10));
	}

	@Test
	public void testCountEven1() {
		Assert.assertEquals(0, LoopUtils.countEvenNumbers(1));
	}

	@Test
	public void testCountEven5() {
		Assert.assertEquals(2, LoopUtils.countEvenNumbers(5));
	}

	@Test
	public void testCountEven10() {
		Assert.assertEquals(5, LoopUtils.countEvenNumbers(10));
	}
}