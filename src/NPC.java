import java.awt.Graphics;

public class NPC extends Sprite{
	
	static String[] poses = { "up", "dn", "lt", "rt"};
	
	/*
	boolean faceup = false;
	boolean facedown = false;
	boolean faceleft = false;
	boolean faceright = false;
	*/
	
	BattleEnemy trainer = new BattleEnemy(3);
	int w = 80;
	int h = 100;
	
	boolean hasBattled = true;
	
	
	Rect box = new Rect(x,y, 30,30);
	Rect rUp = new Rect(x,y -150, 80,150);
	Rect rLeft = new Rect(x -150,y, 150,80);
	Rect rRight = new Rect(x + 80,y, 150,80);
	Rect r4 = new Rect(x,y -150, 80,150);
	
	public NPC(int x, int y) {
		super(x, y, "p", poses, 4, 10);
		//
	}
	
	
	//this checks the npc line of site
	public void site(Graphics g) {
		
		
		if(faceup) {
		g.drawRect(x , y -150, 80, 150);
		}
		
	}
	
	//draws a box if the npc is facing left
	public void leftsite(Graphics g) {
		
		
		if(faceleft) {
		//g.drawRect( x - 150, y, 150, 80);
			rLeft.draw(g);
		}
	}
	
	//draws a box if the npc is face right
	public void rightsite(Graphics g) {
		
		if(faceright) {
		g.drawRect( x + 80 , y, 150, 80);
		}
		
	}
	
	
	//draws a box if the npc is facing down
	public void downsite(Graphics g) {
		
	}
	
	public void setPose(int index) {
		if(index > 0 && index <5) {
			pose = index;
		}
		
	}
	
	public boolean caught(Player p) {
		
		//if(p.x >= x && p.y)
		
		
		return false;
	}
	//TODO ok you decided the we should have enum to decide which way a cracter 
	
	
	//this method tells the npc to stop right in front of the player based on the player location
	// this takes in the player x and y coordinates
	public boolean ishouldstop(int px, int py) {
		
		//boolean result = false;
		//faceup = true;
		/*if(pose == 0 && (y - 50 )>= py) {
			//result = true;
			return true;
		}
		else {
			//result = false;
			return false;
		}
		*/
		
		
		switch(pose) {
		case 0:
			if((y - 50) >= py) {
				return true;
			}
		case 2:
			if((x- 50) >= px) {
				return true;
			}
		case 3:
			if((x + 50) <= px) {
				return true;
			}
			
			
		default:
			return false;
		}
		
		
			//return false;
	}
	
	/*
	@Override
	public void draw(Graphics g)
	{
      if(moving)  
      	
      	g.drawImage(anim[pose].getCurrentImage(), x - (int)Camera.x, y - (int)Camera.y, null);
      
      else
      	
      	g.drawImage(anim[pose].getStillImage(), x - (int)Camera.x, y -(int)Camera.y , null);
      
      moving = false;
      	
	}*/


	@Override
	public void hitbox() {
		// TODO Auto-generated method stub
		
	}
	/*
	public Rectangle getBounds() {
		
	}
	*/
	
}
