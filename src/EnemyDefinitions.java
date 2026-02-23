import java.util.List;

public class EnemyDefinitions {
    public static List<EnemyDefinition> all() {
        return List.of(
                new EnemyDefinition("Skully", "skeleton", 45, 15, 5, 4),
                new EnemyDefinition("Zomber", "zombie", 75, 10, 10, 2),
                new EnemyDefinition("Gobbo", "goblin", 35, 20, 20, 6)
        );
    }
}
