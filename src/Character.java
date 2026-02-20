public class Character {
    //Declare fields here
    private final String name;
    private final String creatureClass;
    private int maxHealth;
    private int remainingHealth;
    private int damagingPower;
    private int armor;
    private String ability1;
    private String ability2;
    private int speed;


    //Write constructure here
    public Character(String name, String playerClass, int maxHealth) {
        this.name = name;
        this.creatureClass = playerClass;
        this.maxHealth = maxHealth;
        this.remainingHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public String getCreatureClass() {
        return creatureClass;
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

    public int getDamagingPower() {
        return damagingPower;
    }

    public void setDamagingPower(int damagingPower) {
        this.damagingPower = damagingPower;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public void takeDamage(int amount) {
        this.remainingHealth = getRemainingHealth() - amount;
        System.out.println(STR."You received \{amount} damage");
    }

    public void heal(int amount) {
        this.remainingHealth = getRemainingHealth() + amount;
    }

    //Write methods here
    public void introduction() {
        System.out.println(
                STR."""

Welcome hero!
Your name:\t\{getName()}
Class:\t\t\{getCreatureClass()}
Health:\t\t\{getRemainingHealth()}/\{getMaxHealth()}""");
    }
}
