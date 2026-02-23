import java.util.concurrent.ThreadLocalRandom;

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
    public Character(String name, String creatureClass, int maxHealth, int damagingPower, int armor, int speed) {
        this.name = name;
        this.creatureClass = creatureClass;
        this.maxHealth = maxHealth;
        this.remainingHealth = maxHealth;
        this.damagingPower = damagingPower;
        this.armor = armor;
        this.speed = speed;
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


    public void heal(int amount) {
        int healthBefore = getRemainingHealth() + amount;
        this.remainingHealth = getRemainingHealth() + amount;
        if (remainingHealth > maxHealth) {
            remainingHealth = maxHealth;
        }
        System.out.println(STR."You received \{maxHealth-healthBefore} healing");
    }

    public void introduction() {
        System.out.println(
                STR."""

Welcome hero!
Your name:\t\{getName()}
Class:\t\t\{getCreatureClass()}
Health:\t\t\{getRemainingHealth()}/\{getMaxHealth()}""");
    }

    public void attackCalculator(Character defender) {
        int hitNumber = (int) (Math.random() * 100);
        if (hitNumber < 5) {
            System.out.println(STR."\{this.getName()}'s attack missed!");
        } else if (hitNumber >= 95) {
            System.out.println(STR."\{this.getName()}'s attack critically hit!");
            takeCriticalDamage(defender);
        } else {
            System.out.println(STR."\{this.getName()}'s attack hit normally!");
            takeDamage(defender);
        }
        if (defender.getRemainingHealth() > 0) {
            System.out.println(STR."\{defender.getName()} has \{defender.getRemainingHealth()}/\{defender.getMaxHealth()} health left\n");
        } else {
            System.out.println(STR."\{defender.getName()} was knocked out");
        }
    }
    private void takeDamage(Character defender) {
        int damageRoll = ThreadLocalRandom.current().nextInt(-5, 6);
//        System.out.println(damageRoll);
        int damageAmount = this.getDamagingPower() - defender.getArmor() + damageRoll;
        if (damageAmount < 1) {
            System.out.println(STR."\{defender.getName()} blocked all damage!");
        } else {
            healthClamper(defender, damageAmount);
            defender.remainingHealth = defender.getRemainingHealth() - damageAmount ;
        }
    }

    private void takeCriticalDamage(Character defender){
        defender.remainingHealth = defender.getRemainingHealth() - this.getDamagingPower() * 2;
        int damageAmount = this.getDamagingPower() * 2;
        healthClamper(defender, damageAmount);
    }

    private void healthClamper(Character defender, int damageAmount){
        int healthBefore = defender.getRemainingHealth();
        if (defender.getRemainingHealth() - damageAmount < 0) {
            damageAmount = healthBefore;
            defender.remainingHealth = 0;
            System.out.println(STR."\{defender.getName()} received \{damageAmount} damage");
        }
    }
}
