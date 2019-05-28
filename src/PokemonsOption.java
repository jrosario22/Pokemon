
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class PokemonsOption {
	private Image arrowImage = Toolkit.getDefaultToolkit().getImage("arrow.png");
	
	private String[] options = {"Summary", "Switch", "Item", "Cancel"};
	
	private int originX = 950;
	private int originY = 450;
	
	private int arrowX = originX + 30;
	private int arrowY = originY + 5;
	
	private int selected = 0;
	
	Font optionFont = new Font("TimesRoman", Font.PLAIN, 30);
	
	public PokemonsOption() {
		
	}
	
	public void moveUp() {
		if (selected > 0) {
			selected--;
			arrowY -= 50;
		}		
	}
	
	public void moveDown() {
		if (selected < options.length - 1) {
			selected++;
			arrowY += 50;
		}
	}
	
	public int getIndex() {
		return selected;
	}
	
	public void reset() {
		selected = 0;
		arrowX = originX + 30;
		arrowY = originY + 5;
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(originX, originY, 250, 250);
		g.setColor(Color.black);
		g.drawRect(originX, originY, 250, 250);
		g.drawImage(arrowImage, arrowX, arrowY, null);
		
		g.setColor(Color.black);
		for(int i = 0; i < options.length; i++) {
			g.setFont(optionFont);
			g.drawString(options[i], originX+100, originY + 50 + (i * 50 ));
		}		
	}
	
	
	
	
	

}
