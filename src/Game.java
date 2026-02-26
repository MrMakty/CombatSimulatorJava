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

        while(player.getRemainingHealth() > 0 && !playerFled && enemy.getRemainingHealth() > 0){
            if (player.getSpeed() < enemy.getSpeed()){
                this.enemyTurn(enemy, player);
                if (player.getRemainingHealth() > 0) {
                    playerFled = this.playerTurn(player, enemy);
                }
            } else {
                playerFled = this.playerTurn(player, enemy);
                if (enemy.getRemainingHealth() > 0) {
                    this.enemyTurn(enemy, player);
                }
            }
            healthDisplay(enemy, player);
        }
    }
    private void healthDisplay(Character enemy, Character player){
        if (player.getRemainingHealth() > 0 && enemy.getRemainingHealth() > 0) {
            System.out.println(STR."\n\{player.getName()} has \{player.getRemainingHealth()}/\{player.getMaxHealth()} health left");
            System.out.println(STR."\{enemy.getName()} has \{enemy.getRemainingHealth()}/\{enemy.getMaxHealth()} health left\n");
        }
    }

    private boolean playerTurn(Character player, Character enemy){
        Scanner input = new Scanner(System.in);
        System.out.println(Menus.ACTION_MENU);
        System.out.println("Enter action number");
        int actionInt = InputUtil.readInt(input, 7);  // Read user input
        switch(actionInt){
            case 1: //Attack
                player.attack(enemy);
                enemy.stopBlocking();
                return false;
            case 2: //Block
                player.startBlocking();
                System.out.println("I choose to block the next attack");
                return false;
            case 3: //Ability
                System.out.println("I choose to use ability 1");
                //The first ability of the class
                return false;
            case 4: //Ability2
                System.out.println("I choose to use ability 2");
                //The second ability of the class
                return false;
            case 5: //Item
                System.out.println("I choose to use an item");
                //Use an item the player has in their inventory
                return false;
            case 6: //Analyze
                System.out.println("I choose to analyze my opponent");
                //Analyze the enemy to see their stats (armor, base attack and abilities
                return false;
            case 7: //Flee
                System.out.println("I choose to try and flee");
                //Attempt to flee. This will be a percentage depending on the speed of the enemy and the player
                return true;
        }
        return false;
    }

    private void enemyTurn(Enemy enemy, Character player){
        //enemy turn goes here
        Enemy.Action action = enemy.chooseAction(enemy, player);
        switch(action){
            case ATTACK -> enemy.attack(player);
            case BLOCK -> enemy.startBlocking();
//            case ABILITY1 ->
//            case ABILITY2 ->
//            case FLEE ->
        }
    }

}