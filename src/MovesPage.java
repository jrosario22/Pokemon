import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;


public class MovesPage {
	private Image moveList = Toolkit.getDefaultToolkit().getImage("../image/movelist.png");
	private Image profileBackground = Toolkit.getDefaultToolkit().getImage("../image/profile.png");
	private Image emptySpace = Toolkit.getDefaultToolkit().getImage("../image/emptyspace.png");
	private Image tabbar = Toolkit.getDefaultToolkit().getImage("../image/tabbar_2.png");
	
	private Pokemon pokemon;
	private ArrayList<Move> moves;
	
	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 36);
	
	public MovesPage () {
		
	}
	
	public void setPokemon (Pokemon pokemon) {
		this.pokemon = pokemon;
		moves = pokemon.moves;
	}
	
	public void draw (Graphics g) {
		g.drawImage(emptySpace, 0, 0, 605, 700, null);
		g.drawImage(profileBackground, 0, 50, 605, 380, null);
		g.drawImage(moveList, 595, 50, 605, 660, null);
		g.drawImage(tabbar, 0, 0, 1200, 50, null);
		g.drawImage(pokemon.bigImage, 150, 150, 250, 250, null);
		
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("KNOWN MOVES", 25, 40);
		g.drawString("Lv " + pokemon.lv + "       " + pokemon.name.toUpperCase(), 25, 105);
				
		int x = 616, y = 78, d = 128;
		for (int i = 0; i < Math.min(4, moves.size()); i++) {
			Move move = moves.get(i);
			
			g.setColor(Color.gray);
			g.fillRect(x, y, 180, 40);
			
			g.setColor(Color.white);
			g.drawString(move.moveType.type.toUpperCase(), x+5, y+35);
			
			g.setColor(Color.black);
			g.drawString(move.moveType.name.toUpperCase(), x+220, y+40);
			g.drawString("pp" + move.ppRemain + "/" + move.moveType.pp, x+350, y+80);
			
			y += d;
		}
	}
	

}