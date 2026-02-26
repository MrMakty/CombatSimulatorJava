import java.util.Random;

public class Enemy extends Character {
    public Enemy(EnemyDefinition def) {
        super(def.name(), def.identifier(), def.maxHealth(), def.damagingPower(), def.armor(), def.speed());
    }

    private static final Random RANDOM = new Random();

    public enum Action {
        ATTACK,
        BLOCK;
//        ABILITY1, //Should be 0 if the ability is on cooldown
//        ABILITY2, //Should be 0 if the ability is on cooldown
//        FLEE; //Let the chance flee grow as the enemy has less health, but only for specific enemies
    }

    public Action chooseAction(Character enemy, Character player) {
        // Base weights
        int attackWeight = 80;
        int blockWeight = 20;

        // If a normal hit (no miss/crit) would definitely kill, always attack.
        int guaranteedDamage = estimateDamage(enemy, player);
        if (player.getRemainingHealth() <= guaranteedDamage) {
            attackWeight = 100;
            blockWeight = 0;
        }
        return weightedRandom(attackWeight, blockWeight);
    }

    private int estimateDamage(Character attacker, Character defender) {
        int minRoll = -5;
        int damage = attacker.getDamagingPower() - defender.getArmor() + minRoll;

        // Your real code does: if damageAmount < 1, no damage is dealt
        return Math.max(0, damage);
    }

    private Action weightedRandom(int attackWeight, int blockWeight) {
        int total = attackWeight + blockWeight;
        if (total <= 0) return Action.ATTACK; // In case something weird happens this is a failsafe

        int roll = RANDOM.nextInt(total); // 0..total-1
        return (roll < attackWeight) ? Action.ATTACK : Action.BLOCK;
    }
}

