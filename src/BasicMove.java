
public class BasicMove {
    public static final BasicMove CUT  = new BasicMove ("Cut", "Normal", "...", 30, 50, 95);
    public static final BasicMove ACID = new BasicMove ("Acid", "Poison", "...", 30, 40, 100);
    public static final BasicMove SURF = new BasicMove ("Surf", "Water", "...", 15, 90, 100);

    String name;
    String type;
    String description;
    int pp;
    int power;
    int accuracy;

    public BasicMove (String name, String type, String description, int pp, int power, int accuracy) {
        this.name        = name;
        this.type        = type;
        this.description = description;
        this.pp          = pp;
        this.power       = power;
        this.accuracy    = accuracy;
    }
}