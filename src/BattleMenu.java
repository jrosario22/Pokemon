import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BattleMenu{
	
	String[] moves;
	Font f = new Font("TimesRoman", Font.PLAIN, 50);
	BattleConditions bc;
	
	Image mainMenu;
	Image arrow;
	Image moveMenu;
	int mainMenuCounter = 0;
	int moveMenuCounter = 0;
	boolean fightMenu = false;
	boolean firstZPress = true;
	
	
	int xa;
	int ya;
	
	public BattleMenu(String[] moves, BattleConditions bc){
		mainMenu = Toolkit.getDefaultToolkit().getImage("MenuBox.png").getScaledInstance(550, 200, Image.SCALE_DEFAULT);
		arrow = Toolkit.getDefaultToolkit().getImage("arrow.png").getScaledInstance(30, 40, Image.SCALE_DEFAULT);
		moveMenu = Toolkit.getDefaultToolkit().getImage("moveMenu.png").getScaledInstance(1200, 200, Image.SCALE_DEFAULT);
		
		xa = 685;
		ya = 550;
		
		this.moves = moves;
		this.bc = bc;
	}
	
	public void draw(Graphics g){
		g.drawImage(mainMenu, 650, 500, null);
		
		if(!fightMenu){
			g.drawImage(arrow, xa, ya, null);
		}
		
		if(fightMenu) {
			g.drawImage(moveMenu, 0, 500, null);
			g.setFont(f);
			g.drawString(moves[0], 70, 580);
			g.drawString(moves[1], 470, 580);
			g.drawString(moves[2], 70, 640);
			g.drawString(moves[3], 470, 640);
			g.drawImage(arrow, xa, ya, null);
		}
	}
	
	public void moveArrowLeft() {
		if(!fightMenu) {
			if(mainMenuCounter == 1 || mainMenuCounter == 3) {
				xa -= 250;
				mainMenuCounter--;
			}else if(mainMenuCounter == 2) {
				xa += 250;
				ya -= 70;
				mainMenuCounter--;
			}else{
				xa = 935;
				ya = 620;
				mainMenuCounter = 3;
			}
		}else{
			if(moveMenuCounter == 1 || moveMenuCounter == 3) {
				xa -= 400;
				moveMenuCounter--;
			}else if(moveMenuCounter == 2) {
				xa += 400;
				ya -= 80;
				moveMenuCounter--;
			}else{
				xa = 430;
				ya = 620;
				moveMenuCounter = 3;
			}
		}
		
	}
	
	public void moveArrowRight() {
		if(!fightMenu) {
			if(mainMenuCounter == 0 || mainMenuCounter == 2) {
				xa += 250;
				mainMenuCounter++;
			}else if(mainMenuCounter == 1) {
				xa -= 250;
				ya += 70;
				mainMenuCounter++;
			}else{
				xa = 685;
				ya = 550;
				mainMenuCounter = 0;
			}
		}else {
			if(moveMenuCounter == 0 || moveMenuCounter == 2) {
				xa += 400;
				moveMenuCounter++;
			}else if(moveMenuCounter == 1) {
				xa -= 400;
				ya += 80;
				moveMenuCounter++;
			}else{
				xa = 30;
				ya = 540;
				moveMenuCounter = 0;
			}
		}
	}
	
	public void moveArrowUp() {
		if(mainMenuCounter == 2 || mainMenuCounter == 3) {
			ya -= 70;
			mainMenuCounter -= 2;
		}else if(mainMenuCounter == 0 || mainMenuCounter == 1) {
			ya += 70;
			mainMenuCounter += 2;
		}else{
			xa = 685;
			ya = 550;
			mainMenuCounter = 0;
		}
	}
	
	public void moveArrowDown() {
//		ya += 70;
		if(mainMenuCounter == 0 || mainMenuCounter == 1) {
			ya += 70;
			mainMenuCounter += 2;
		}else if(mainMenuCounter == 2 || mainMenuCounter == 3) {
			ya -= 70;
			mainMenuCounter -= 2;
		}else{
			xa = 685;
			ya = 550;
			mainMenuCounter = 0;
		}
	}

	public void pressZ() {
		switch(mainMenuCounter) {	
		case 0:
			if(firstZPress) {
				xa = 30;
				ya = 540;
				fightMenu = true;
				firstZPress = false;
			}else {
				boolean attacked = false;
				do {
					do {
						
					}while(attacked);
				}while(attacked);
				bc.fight();
				System.out.println("curhp: " + bc.aPkmn.hp);
				System.out.println("curhp: " + bc.ePkmn.hp);
			}
			break;
		case 1:
		case 2:
		case 3:
		default:
			break;
		}
		
	}

	public void pressX() {
		if(fightMenu){
			xa = 685;
			ya = 550;
			fightMenu = false;
			firstZPress = true;
		}
		
	}
	
	
//	public void drawArrow(Graphics g){
//		
//	}

}