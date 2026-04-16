package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest {

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
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyValidationCodeAfterSuccessfulLogin() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean valid = LoginForm.validateCode(null);
        Assert.assertFalse(valid);
    }

    @Test
    public void testFailWrongValidationCodeAfterSuccessfulLogin() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean valid = LoginForm.validateCode("abcd");
        Assert.assertFalse(valid);
    }

    @Test
    public void testSuccessCorrectValidationCodeAfterSuccessfulLogin() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean valid = LoginForm.validateCode("123456");
        Assert.assertTrue(valid);
    }
}
