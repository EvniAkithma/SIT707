package task6_2D;

import static org.junit.Assert.*;
import org.junit.Test;

public class OnTrackFunctionsTest {

    OnTrackFunctions obj = new OnTrackFunctions();

    // RIGHT
    @Test
    public void testCorrectLogin() {
        assertTrue(obj.login("student", "deakin123"));
    }

    // BOUNDARY
    @Test
    public void testEmptyTaskSubmission() {
        assertFalse(obj.submitTask(""));
    }

    // INVERSE
    @Test
    public void testWrongLogin() {
        assertFalse(obj.login("wrong", "wrong"));
    }

    // CROSS-CHECK
    @Test
    public void testAverageCalculation() {
        assertEquals(80.0, obj.calculateAverage(70, 80, 90), 0.01);
    }

    // ERROR
    @Test
    public void testNullSubmission() {
        assertFalse(obj.submitTask(null));
    }

    // PERFORMANCE
    @Test
    public void testMessageCounter() {
        int[] messages = {1,2,3,4,5};
        assertEquals(5, obj.countUnreadMessages(messages));
    }
}