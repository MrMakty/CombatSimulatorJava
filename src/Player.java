public class Player extends Character {
    //Player-specific fields here
    private int gold;
//    private XXX inventory

    public Player(String playerName, String playerClass, int playerHealth) {
        super(playerName, playerClass, playerHealth);
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
