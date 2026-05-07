package web.service;

/**
 * Business logic to handle login functions.
 */
public class LoginService {

	public static boolean login(String username, String password, String dob) {

		if (username == null || password == null || dob == null) {
			return false;
		}

		username = username.trim();
		password = password.trim();
		dob = dob.trim();

		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}

		// validate yyyy-mm-dd
		if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
			return false;
		}

		// valid login
		if ("ahsan".equals(username)
				&& "ahsan_pass".equals(password)
				&& "1990-01-01".equals(dob)) {
			return true;
		}

		return false;
	}
}