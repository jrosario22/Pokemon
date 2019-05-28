import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class OptionMenu {
	
	Image image = Toolkit.getDefaultToolkit().getImage("arrow.png");
	Bag bag = new Bag();
	//int[] arr = new int[3];
	
	//use objects instead? "Exit"?
	String[] options = {"Pokemon","Bag","Save", "Exit"};
	
	int originX = 950;
	int originY = 100;
	
	int arrowX = originX + 30;
	int arrowY = originY ;
	
	//boolean bagappear = false;
	
	//int arrowX = originX + 50;
	//int arrowY = originY + 50;
	
	
	//int arrowX = 150;
	//int arrowY = 150;
	
	private int selectedIndex =0;
	
	//private List arrows = new ArrayList<Image>();
	
	public int getIndex() {
		return selectedIndex;
	}
	
	public OptionMenu() {
		
		//addKeyListener(this);
		/*
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		
	}
	
	
	public void addOption(String option) {
		
	}//
	
	
	
	public void moveUp() {
		
		if(GameState.isOption() && selectedIndex > 0 ) {
			selectedIndex--;
			arrowY -= 50;
			System.out.println("i should move down");
			
		}
		
		
	}
	
	public void moveDown() {
		if(GameState.isOption() && selectedIndex <= options.length - 1) {
			selectedIndex++;
			arrowY += 50;
			System.out.println("i should move up");
			
		}
	}
		
	
	//selected
	public int getOption() {
		
		return 0;
	}
	
	public void draw(Graphics g) {
		
		g.drawRect(originX, originY, 300, 300);
		g.setColor(Color.white);
		g.fillRect(originX, originY, 300, 300);
		
		g.drawImage(image, arrowX, arrowY, null);
		
		g.setColor(Color.black);
		for(int i = 0; i < options.length; i++) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString(options[i], 1050, 150 + (i * 50 ));
		}
		
		//if(bagappear == true) {
			//bag.draw(g);
		//}
		
	}

/*
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//might want to put a or statementf if the pressed the exit option
		if(e.getKeyCode() == KeyEvent.VK_ENTER && GameState.isOption()) {
			GameState.setState(GameState.idle);
			System.out.println("I hate you i'm leaving");
		}
		
		
		else if(e.getKeyCode() == KeyEvent.VK_ENTER && GameState.isIdle()) {
			GameState.setState(GameState.option);
			System.out.println("of course i love you");
			//bagappear = true;
		
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_UP && GameState.isOption()) moveUp();
		
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN && GameState.isOption()) moveDown();
		
		//the z key will be used to s
		//and for the dialogue pick
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			System.out.println("the z key was pressed");
			
			switch(selectedIndex) {
			case 0: GameState.setState(GameState.pokemon);
			System.out.println("the pokemon screen should appear");
			break;
			
			case 1: GameState.setState(GameState.bag);
			System.out.println("the bag screen appeared");
			break;
			
			case 2: GameState.setState(GameState.bag);
			
			break;
			
			case 3: GameState.setState(GameState.idle);
			System.out.println("went back to idle");
				
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	*/

}
