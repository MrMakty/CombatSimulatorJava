import java.util.Scanner;  // Import the Scanner class

public class InputUtil {
    int classChoiceInt;
    public int readInt(String value, int maxValue){
        try {
            classChoiceInt = Integer.parseInt(value);
        }
        catch(NumberFormatException e) {
            System.out.println("Your input was invalid. Please try again");
        }
        return classChoiceInt;
    }
}
