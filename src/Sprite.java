
import java.awt.*;

public abstract class Sprite
{
	int x;
	int y;
	
	Animation[] anim;
	
	int pose = 3;
	
	
	 enum direction{ up, down , left, right};
	
	boolean moving = false;
	boolean faceup = false;
	boolean facedown = false;
	boolean faceleft = false;
	boolean faceright = false;
	
	
	public Sprite(int x, int y, String name, String[] poses, int count, int duration)
	{
		this.x = x;
		this.y = y;
		
		anim = new Animation[poses.length];
		
		for(int i = 0; i < poses.length; i++)
			
			anim[i] = new Animation(name + "_" + poses[i], count, duration);
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	
	public void moveUp(int dist)
	{
		y -= dist;
		faceup = true;
		facedown = false;
		faceleft = false;
		faceright = false;
		
		
		
		pose = 0;
		
      moving = true;		
	}
	
	public void moveDown(int dist)
	{
		y += dist;
		faceup = false;
		facedown = true;
		faceleft = false;
		faceright = false;
		
		
		pose = 1;

      moving = true;		
}

	public void moveLeft(int dist)
	{
		x -= dist;
		faceup = false;
		facedown = false;
		faceleft = true;
		faceright = false;
		
		
		pose = 2;

      moving = true;		
   }
	
	public void moveRight(int dist)
	{
		x += dist;
		faceup = false;
		facedown = false;
		faceleft = false;
		faceright = true;
		
		
		pose = 3;
	
      moving = true;		
   }
	
	public void draw(Graphics g)
	{
      if(moving)  
      	
      	g.drawImage(anim[pose].getCurrentImage(), x - (int)Camera.x, y -(int)Camera.y, null);
      
      else
      	
      	g.drawImage(anim[pose].getStillImage(), x - (int)Camera.x, y -(int)Camera.y , null);
      
      moving = false;
      	
	}
	
	public abstract void hitbox();

}