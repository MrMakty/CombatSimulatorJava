import java.util.Scanner;

public class Game {
    public void start() {
        Scanner input = new Scanner(System.in);
        String classChoice;
        String playerClass = "";
        int playerHealth = 0;
        boolean classAccepted = false;
        boolean playerFled = false;

        System.out.println(Menus.CLASS_MENU);

        System.out.println("Please enter the number of the class you want to fight as:");

        int classChoiceInt = InputUtil.readInt(input, 3);
        playerClass = switch (classChoiceInt) {
            case 1 -> {
                playerHealth = 50;
                yield "Mage";
            }
            case 2 -> {
                playerHealth = 100;
                yield "Warrior";
            }
            case 3 -> {
                playerHealth = 70;
                yield "Ranger";
            }
            default -> playerClass;
        };

        System.out.println("Enter username");

        String playerName = input.nextLine();  // Read user input

        Player player = new Player(playerName, playerClass, playerHealth);
        player.introduction();

        System.out.println(Menus.ACTION_MENU);

        while(player.getRemainingHealth() > 0 && !playerFled){
            System.out.println("Enter action number");
            String actionChoice = input.nextLine();  // Read user input
            int actionInt;
            try {
                actionInt = Integer.parseInt(actionChoice);
            }
            catch(NumberFormatException e) {
                System.out.println("Your input was invalid. Please try again");
                continue;
            }
            switch(actionInt){
                case 1: //Attack
                    System.out.println("I choose to attack");
                    System.out.println("A mysterious force attacks you");
                    player.takeDamage(50000);
                    break;
                case 2: //Block
                    System.out.println("I choose to block the next attack");
                    break;
                case 3: //Ability
                    System.out.println("I choose to use an ability");
                    break;
                case 4: //Item
                    System.out.println("I choose to use an item");
                    break;
                case 5: //Analyze
                    System.out.println("I choose to analyze my opponent");
                    break;
                case 6: //Flee
                    System.out.println("I choose to try and flee");
                    playerFled = true;
                    break;
                default:
                    System.out.println("Your input was invalid. Please try again");
                    System.out.println(Menus.ACTION_MENU);
            }
        }
    }
}