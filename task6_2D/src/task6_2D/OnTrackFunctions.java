package task6_2D;

public class OnTrackFunctions {

    // Student Login Validation
    public boolean login(String username, String password) {
        return username.equals("student") && password.equals("deakin123");
    }

    // Task Submission Validation
    public boolean submitTask(String taskName) {
        return taskName != null && !taskName.trim().isEmpty();
    }

    // Grade Calculator
    public double calculateAverage(int mark1, int mark2, int mark3) {
        return (mark1 + mark2 + mark3) / 3.0;
    }

    // Inbox Message Counter
    public int countUnreadMessages(int[] messages) {
        return messages.length;
    }
}