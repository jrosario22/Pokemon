import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BattleText{
	
	Image pic;
	Image resize;
	String[] options = {"Pokemon","Bag","Save", "Exit"};
	
	public BattleText(){
		pic = Toolkit.getDefaultToolkit().getImage("TextBox.png");
		resize = pic.getScaledInstance(1200, 200, Image.SCALE_DEFAULT);
	}
	
	public void draw(Graphics g){
		g.drawImage(resize, 0, 500, null);
		
//		for(int i = 0; i < options.length; i++) {
//			g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
//			g.drawString(options[i], 1050, 150 + (i * 50 ));
//		}
	}
	
}
