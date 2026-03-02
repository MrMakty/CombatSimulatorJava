public class AbilityDefinition {

    private final String id;
    private final String name;
    private final String type; // later we can make this an enum
    private final int value;
    private final int cooldown;
    private final String target; // "self" or "enemy"

    public AbilityDefinition(String id, String name, String type,
                             int value, int cooldown, String target) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.cooldown = cooldown;
        this.target = target;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getValue() { return value; }
    public int getCooldown() { return cooldown; }
    public String getTarget() { return target; }
}