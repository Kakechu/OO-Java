package Utilities;

import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);


    public static int getValidInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input); // Yritetään muuntaa syöte kokonaisluvuksi.
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

    }

}
