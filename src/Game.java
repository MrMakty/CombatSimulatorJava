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
                chosenClass.maxHealth(),
                chosenClass.damagingPower(),
                chosenClass.armor(),
                chosenClass.speed()
        );

        List<EnemyDefinition> enemies = EnemyDefinitions.all();
        EnemyDefinition def = enemies.get(1);
        Enemy enemy = new Enemy(def);
        System.out.println(enemy.getName());

        player.introduction();

        System.out.println(Menus.ACTION_MENU);

        while(player.getRemainingHealth() > 0 && !playerFled && enemy.getRemainingHealth() > 0){
            System.out.println("Enter action number");
            int actionInt = InputUtil.readInt(input, 7);  // Read user input
            switch(actionInt){
                case 1: //Attack
                    //When attacking the enemy and player both attack, the speed of both decide which attacks first
                    if (player.getSpeed() < enemy.getSpeed()){
                        enemy.attack(player);
                        if (player.getRemainingHealth() > 0){
                            player.attack(enemy);
                        }
                    } else {
                        player.attack(enemy);
                        if (enemy.getRemainingHealth() > 0) {
                            enemy.attack(player);
                        }
                    }
                    if (player.getRemainingHealth() > 0 && enemy.getRemainingHealth() > 0) {
                        System.out.println(STR."\n\{player.getName()} has \{player.getRemainingHealth()}/\{player.getMaxHealth()} health left");
                        System.out.println(STR."\{enemy.getName()} has \{enemy.getRemainingHealth()}/\{enemy.getMaxHealth()} health left\n");
                    }
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
            }
        }
    }
}