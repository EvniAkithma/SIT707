package sit707_week2;

public class Main 
{
    public static void main(String[] args)
    {
        // Officeworks
        SeleniumOperations.officeworks_registration_page(
            "https://www.officeworks.com.au/app/identity/create-account"
        );
        
        // Second website (LOCAL FILE)
        SeleniumOperations.second_registration_page(
            "file:///C:/Users/ASUS/Desktop/Java_Projects/task2_1P/src/main/java/sit707_week2/webpage1.html"
        );
    }
}