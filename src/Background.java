import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Background {
	
	Image image;
	Image n;
	
	int x;
	int y;
	int z;
	
	
	
	public Background(int x, int y, int z, String filename) {
		this.x = x;
		this.y = y;
		this.z = z;
		image = Toolkit.getDefaultToolkit().getImage(filename);
		n = image.getScaledInstance(5000, 2000, Image.SCALE_DEFAULT);
	}
	
	
	public void draw(Graphics g) {
//		for(int i =0; i < 50; i++) {
//			g.drawImage(image, (int)(x + 720*i - Camera.x / z), (int)(y- Camera.y / z), null);
//		}
		
		
		g.drawImage(n, x - (int)Camera.x, y - (int)Camera.y, null);
		//g.drawImage(n, x , y, null);
	}

}
