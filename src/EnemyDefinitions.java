import java.util.List;

public class EnemyDefinitions {
    public static List<EnemyDefinition> all() {
        return List.of(
                new EnemyDefinition("skeleton", "Skully", 45, 15, 5, 4),
                new EnemyDefinition("zombie", "Zomber", 75, 10, 10, 2),
                new EnemyDefinition("goblin", "Gobbo", 35, 20, 20, 6)
        );
    }
}
