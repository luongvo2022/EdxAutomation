package selenium4.com.utils;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getURLCourse() {
        System.out.print("Enter the URL of the course: ");
        return scanner.nextLine();
    }

    public String getBrowser() {
        System.out.print("Enter the browser (chrome/firefox/edge): ");
        return scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison
    }

    public void closeScanner() {
        scanner.close();
    }
}
