public class Player {
    //Declare fields here
    private final String name;
    private final String playerClass;
    private int maxHealth;
    private int remainingHealth;

    //Write constructure here
    public Player(String name, String playerClass, int maxHealth) {
    this.name = name;
    this.playerClass = playerClass;
    this.maxHealth = maxHealth;
    this.remainingHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        this.remainingHealth = remainingHealth;
    }

    public void takeDamage(int amount){
        this.remainingHealth = getRemainingHealth() - amount;
        System.out.println("You received " + amount + " damage");
    }

    public void heal(int amount){
        this.remainingHealth = getRemainingHealth() + amount;
    }

    //Write methods here
    public void introduction() {
        System.out.println(
                "\nWelcome hero!\nYour name:\t" + getName() + "\nClass:\t\t" + getPlayerClass() +
                        "\nHealth:\t\t" + getRemainingHealth() + "/" + getMaxHealth());
    }
}
