import java.util.Scanner;  // Import the Scanner class
public class InputUtil {
    public static int readInt(Scanner input, int maxValue) {
        while (true) {
            int ChoiceInt;
            // read line
            String Choice = input.nextLine();
            // try parse
            try {
                ChoiceInt = Integer.parseInt(Choice);
            } catch (NumberFormatException e) {
                // if invalid → print message and continue
                System.out.println("Your input included something beside a number. Please try again.");
                continue;
            }
            if (1 > ChoiceInt || ChoiceInt > maxValue) {
                // if < 1 or > maxValue → print message and continue
                System.out.println("Your input was lower than 1 or higher then the max amount of " + maxValue + ". Please try again");
            }
            else{
            // else return number
            return ChoiceInt;
            }
        }
    }
}