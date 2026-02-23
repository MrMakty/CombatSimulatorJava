import java.util.List;
import java.util.Scanner;

public class Game {
    public void start() {
        Scanner input = new Scanner(System.in);
        boolean playerFled = false;

        List<HeroClass> heroClasses = HeroClasses.all();

        for (int i = 0; i < heroClasses.size(); i++) {
            HeroClass hc = heroClasses.get(i);
            System.out.println(STR."\{i + 1}: \{hc.displayName()}");
        }

        System.out.println("Please enter the number of the class you want to fight as:");

        int choice = InputUtil.readInt(input, heroClasses.size());
        HeroClass chosenClass = heroClasses.get(choice - 1);

//        System.out.println("Enter username");

        String playerName = "Makty"; //Temporary placeholder to make testing quicker
//        String playerName = input.nextLine();  // Read user input

        Player player = new Player(
                playerName,
                chosenClass.displayName(),
                chosenClass.maxHealth()
        );

        player.introduction();

        System.out.println(Menus.ACTION_MENU);

        while(player.getRemainingHealth() > 0 && !playerFled){
            System.out.println("Enter action number");
            int actionInt = InputUtil.readInt(input, 7);  // Read user input
            switch(actionInt){
                case 1: //Attack
                    System.out.println("I choose to attack");
                    //When attacking the enemy and player both attack, the speed of both decide which attacks first
                    //Temporary placeholder to check death
                    System.out.println("The mysterious force dodged your attack");
                    System.out.println("A mysterious force attacks you");
                    player.takeDamage(50000);
                    break;
                case 2: //Block
                    System.out.println("I choose to block the next attack");
                    //Either dubbel armor or halve damage. I think halve damage is easier to do as armor might change during the game as statuses will be implemented
                    break;
                case 3: //Ability
                    System.out.println("I choose to use ability 1");
                    //The first ability of the class
                    break;
                case 4: //Ability2
                    System.out.println("I choose to use ability 2");
                    //The second ability of the class
                    break;
                case 5: //Item
                    System.out.println("I choose to use an item");
                    //Use an item the player has in their inventory
                    break;
                case 6: //Analyze
                    System.out.println("I choose to analyze my opponent");
                    //Analyze the enemy to see their stats (armor, base attack and abilities
                    break;
                case 7: //Flee
                    System.out.println("I choose to try and flee");
                    //Attempt to flee. This will be a percentage depending on the speed of the enemy and the player
                    playerFled = true;
                    break;
                default:
                    System.out.println("Your input was invalid. Please try again");
                    System.out.println(Menus.ACTION_MENU);
            }
        }
    }
}