package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

	@Test
	public void testValidLogin() {
		Assert.assertTrue(
				LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testWrongUsername() {
		Assert.assertFalse(
				LoginService.login("wrong", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testWrongPassword() {
		Assert.assertFalse(
				LoginService.login("ahsan", "wrong", "1990-01-01"));
	}

	@Test
	public void testWrongDob() {
		Assert.assertFalse(
				LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
	}

	@Test
	public void testNullUsername() {
		Assert.assertFalse(
				LoginService.login(null, "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testNullPassword() {
		Assert.assertFalse(
				LoginService.login("ahsan", null, "1990-01-01"));
	}

	@Test
	public void testNullDob() {
		Assert.assertFalse(
				LoginService.login("ahsan", "ahsan_pass", null));
	}

	@Test
	public void testEmptyInput() {
		Assert.assertFalse(
				LoginService.login("", "", ""));
	}

	@Test
	public void testInvalidDobFormat() {
		Assert.assertFalse(
				LoginService.login("ahsan", "ahsan_pass", "01-01-1990"));
	}

	@Test
	public void testSpacesInput() {
		Assert.assertTrue(
				LoginService.login(" ahsan ", " ahsan_pass ", " 1990-01-01 "));
	}
}