
public class Player extends Sprite{
	
	static String[] poses = { "up", "dn", "lt", "rt"};
	
	
	int w = 80;
	int h = 100;
	
	BattleTrainer trainer = new BattleTrainer(0);
	
	
	
	public Player(int x, int y) {
		super(x, y, "p", poses, 4, 10);
	}
	
	
	public void setPose(int index) {
		if(index > 0 && index <5) {
			pose = index;
		}
		
	}



	@Override
	public void hitbox() {
		// TODO Auto-generated method stub
		//g.draw()
		
	}
	

}
