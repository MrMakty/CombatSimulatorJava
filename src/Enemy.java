public class Enemy extends Character {
    public Enemy(EnemyDefinition def) { super(def.name(), def.identifier(), def.maxHealth(), def.damagingPower(), def.armor(), def.speed());}
    }
