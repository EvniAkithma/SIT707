package sit707_week6;

public class LoopUtils {

	// Part B(a): conditional loop with simple statement
	public static int sumNumbers(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		return sum;
	}

	// Part B(b): loop with conditional statement inside
	public static int countEvenNumbers(int n) {
		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				count++;
			}
		}

		return count;
	}
}