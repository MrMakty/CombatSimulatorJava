import java.util.List;

public class EnemyDefinitions {
    public static List<EnemyDefinition> all() {
        return List.of(
                new EnemyDefinition("Skully", "skeleton", 45, 15, 5, 4, "bone_toss", "brace_shield"),
                new EnemyDefinition("Zomber", "zombie", 75, 10, 10, 2, "bite", "regenrate"),
                new EnemyDefinition("Gobbo", "goblin", 35, 20, 20, 6, "brace_shield", "slash")
        );
    }
}
