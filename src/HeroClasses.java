import java.util.List;

public class HeroClasses {
    public static List<HeroClass> all() {
        return List.of(
                new HeroClass("Mage", 50, 60, 5, 6, 5),
                new HeroClass("Warrior", 150, 20, 20, 3, 10),
                new HeroClass("Ranger", 100, 30, 15, 9, 20),
                new HeroClass("Paladin", 200, 15, 25, 2, 7)
        );
    }
}
