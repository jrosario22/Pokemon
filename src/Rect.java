
import java.awt.*;


public class Rect
{
	int x;
	int y;
	
	int w;
	int h;
	
	double vx = 0;
	double vy = 0;
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
	}
	
	public void bounceX()
	{
		vx *= -1;
	}
	
	public void moveForward()
	{
		x += vx;
		y += vy;
	}
	
	public void setVelocity(double speed, int direction)
	{
		vx = speed * Lookup.cos[direction];
		vy = speed * Lookup.sin[direction];		
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public void moveUpBy(int dy)
	{
		y -= dy;
	}
	
	public void moveDownBy(int dy)
	{
		y += dy;
	}
	
	public boolean overlaps(Rect r)
	{
		return (r.x + r.w >=   x)  &&
				 (  x +   w >= r.x)  &&
				 (r.y + r.h >=   y)  &&
				 (  y +   h >= r.y);
	}
	
	public boolean overlapss(NPC r)
	{
		return (r.x + r.w >=   x)  &&
				 (  x +   w >= r.x)  &&
				 (r.y + r.h >=   y)  &&
				 (  y +   h >= r.y);
	}
	
	public boolean overlapss(Player r)
	{
		return (r.x + r.w >=   x)  &&
				 (  x +   w >= r.x)  &&
				 (r.y + r.h >=   y)  &&
				 (  y +   h >= r.y);
	}


	
	public boolean contains(int mx, int my)
	{
		return (mx >= x)  &&  (mx <= x+w)  &&  (my <= y)  &&  (my >= y+h);
	}
	
	public void draw(Graphics g)
	{
		g.drawRect(x - (int)Camera.x , y - (int)Camera.y, w, h);
		//System.out.println("x: " +x + "y: " + y + "w " + w + "h " + h);
	}

}