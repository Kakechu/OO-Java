import java.util.Scanner;

class InvalidMouseAgeException extends Exception {

    public InvalidMouseAgeException(String message) {
        super(message);
    }
}

class InvalidMouseNameException extends Exception {

    public InvalidMouseNameException(String message) {
        super(message);
    }
}


class MouseValidator { //huom. ei public

    public static void validateMouse(String name, int age) throws InvalidMouseAgeException, InvalidMouseNameException {
        if (name == null || name.isEmpty() || name.equals("password")) {
            throw new InvalidMouseNameException("Mouse name cannot be null or empty or 'Password'");
        }

        if (age < 1) {
            throw new InvalidMouseAgeException("Mouse age must be 1 year or older.");
        }

        System.out.println("Mouse is valid.");
    }

}

class TestMouseExceptions {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean syoteOK = false;

        do {

            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine()); //käsitellään Stringinä

            try {
                //MouseValidator.validateMouse("Minnie", 2);
                //MouseValidator.validateMouse("Minnie", 1);
                //MouseValidator.validateMouse("Minnie", 0.2);
                //MouseValidator.validateMouse("Mickey", 0);
                //MouseValidator.validateMouse("password", 2);
                //MouseValidator.validateMouse(null, 3);
                //MouseValidator.validateMouse("null", 4);
                //MouseValidator.validateMouse("", 5);
                //MouseValidator.validateMouse("password", 0);
                MouseValidator.validateMouse(name, age);
                syoteOK = true;

            } catch (InvalidMouseNameException | InvalidMouseAgeException e) { //voi olla myös kaksi catchia
                System.out.println("Mouse validation error: " + e.getMessage());
            }
        } while (!syoteOK);

    }
}
