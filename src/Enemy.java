public class Enemy extends Character {
    public Enemy(EnemyDefinition def) { super(def.identifier(), def.name(), def.maxHealth(), def.damagingPower(), def.armor(), def.speed());}
    }
