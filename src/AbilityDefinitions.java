import java.util.List;

public class AbilityDefinitions {

    public static List<AbilityDefinition> all() {
        return List.of(
            new AbilityDefinition("slash", "Slash", "damage", 50, 3, "enemy"),
            new AbilityDefinition("healing_salve", "Healing Salve", "heal", 30, 5, "self"),
            new AbilityDefinition("fireball", "Fireball", "damage", 40, 5, "enemy"),
            new AbilityDefinition("brace_shield", "Brace Shield", "armor", 20, 3, "self"),
            new AbilityDefinition("precision_shot", "Precision shot", "damage", 40, 3, "enemy"),
            new AbilityDefinition("mud_throw", "Mud throw", "damage", 15, 3, "enemy"),
            new AbilityDefinition("bone_toss", "Bone toss", "damage", 25, 3, "enemy"),
            new AbilityDefinition("regenerate", "Regenerate", "heal", 40, 10, "self"),
            new AbilityDefinition("stone_skin", "Stone_skin", "armor", 25, 2, "self"),
            new AbilityDefinition("bite", "Bite", "damage", 25, 2, "enemy"),
            new AbilityDefinition("mage_armor", "Mage armor", "armor", 20, 5, "self"),
            new AbilityDefinition("smite", "Smite", "damage", 40, 3, "enemy"),
            new AbilityDefinition("lay_on_hands", "Lay on hands", "healing", 25, 3, "self"),
            new AbilityDefinition("*****", "******", "******", 1000, 10000, "enemy")
        );
    }

    public static AbilityDefinition getById(String id) {
        return all().stream()
                .filter(a -> a.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
