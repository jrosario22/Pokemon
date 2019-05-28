
public class MoveType {
	public static final MoveType CUT  = new MoveType ("Cut", "Normal", "...", 30, 50, 95);
	public static final MoveType ACID = new MoveType ("Acid", "Poison", "...", 30, 40, 100);
	public static final MoveType SURF = new MoveType ("Surf", "Water", "...", 15, 90, 100);
	public static final MoveType FLASH = new MoveType ("Flash", "Normal", "...", 20, 0, 100);
	
	
	
	public static final MoveType BITE = new MoveType ("Bite", "Dark", "...", 25, 60, 100);
	public static final MoveType BUBBLE = new MoveType ("Bubble", "Water", "...", 30, 20, 100);
	public static final MoveType EMBER = new MoveType ("Ember", "Fire", "...", 20, 0, 100);
	public static final MoveType GUST = new MoveType ("Gust", "Flying", "...", 25, 60, 100);
	public static final MoveType MAGICAL_LEAF = new MoveType ("Magical Leaf", "Grass", "...", 20, 60, 100);
	public static final MoveType METAL_CLAW = new MoveType ("Metal Claw", "Steel", "...", 35, 50, 95);
	public static final MoveType QUICK_ATTACK = new MoveType ("Quick Attack", "Normal", "...", 30, 40, 100);
	public static final MoveType RAZOR_LEAF = new MoveType ("Razor Leaf", "Grass", "...", 25, 55, 95);
	public static final MoveType SCRATCH = new MoveType ("Scratch", "Normal", "...", 35, 40, 100);
	public static final MoveType SLAM = new MoveType ("Slam", "Normal", "...", 20, 80, 75);
    public static final MoveType TACKLE = new MoveType ("Tackle", "Normal", "...", 35, 35, 95);
    public static final MoveType THUNDERSHOCK = new MoveType ("ThunderShock", "Electric", "...", 30, 40, 100);
    public static final MoveType VINE_WHIP = new MoveType ("Vine Whip", "Grass", "...", 10, 35, 100);
    public static final MoveType WATER_GUN = new MoveType ("Water Gun", "Water", "...", 25, 40, 100);
    public static final MoveType WING_ATTACK = new MoveType ("Wing Attack", "Flying", "...", 35, 60, 100);
   
	
	String name;
	String type;
	String description;	
	int pp;
	int power;
	int accuracy;
	
	public MoveType (String name, String type, String description, int pp, int power, int accuracy) {
		this.name        = name;
		this.type        = type;
		this.description = description;
		this.pp          = pp;
		this.power       = power;
		this.accuracy    = accuracy;
	}
}
