import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GrassField extends Rectangle {
	
	int x = 700;
	int y = 200;
	int w = 200;
	int h = 300;
	
	public GrassField() {
		
	}
	

	
	public GrassField(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		//g.drawRect(100 - (int)Camera.x, 100 - (int)Camera.y, 60, 100);
		g.setColor(Color.red);
		g.drawRect(x - (int)Camera.x, y - (int)Camera.y, w, h);
		
		
	}
	
	public boolean containss(Player r) {
		
		return (r.x + r.w >=   x)  &&
				 (  x +   w >= r.x)  &&
				 (r.y + r.h >=   y)  &&
				 (  y +   h >= r.y);
		
	}
	

}
