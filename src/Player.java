public class Player extends Character {
    //Player-specific fields here
    private int gold;
//    private XXX inventory

    public Player(String playerName, String playerClass, int playerHealth, int playerDamagingPower, int playerArmor, int playerSpeed) {
        super(playerName, playerClass, playerHealth, playerDamagingPower, playerArmor, playerSpeed);
        this.gold = 0;
        // player-specific initialization here
    }
    //Declare fields here

    //Write constructure here
    public int getGold() {
        return gold;
    }

    //Write methods here
    public void addGold(int amount) {
        gold += amount;
    }
}
