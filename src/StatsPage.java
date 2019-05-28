
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class StatsPage {
	private Image background = Toolkit.getDefaultToolkit().getImage("../image/stats.png");
	private Image profileBackground = Toolkit.getDefaultToolkit().getImage("../image/profile.png");
	private Image tabbar = Toolkit.getDefaultToolkit().getImage("../image/tabbar_1.png");
	
	Pokemon pokemon;
	
	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 36);
	
	public StatsPage () {

	}

	
	public void setPokemon (Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void draw (Graphics g) {
		g.drawImage(background, 0, 50, 1200, 650, null);
		g.drawImage(profileBackground, 0, 50, 605, 380, null);
		g.drawImage(tabbar, 0, 0, 1200, 50, null);
		g.drawImage(pokemon.bigImage, 150, 150, 250, 250, null);
		
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("POKEMON SKILLS", 25, 40);
		g.drawString("Lv " + pokemon.lv + "       " + pokemon.name.toUpperCase(), 25, 105);
		
		g.setColor(Color.black);
		g.drawString(pokemon.hp + " / " + pokemon.hpMax, 860, 110);
		
		int x = 1030, y = 195, i = 1, d = 58;
		g.drawString(pokemon.attack+"", x, y);
		g.drawString(pokemon.defense+"", x, y+d*i++);
		g.drawString("N/A", x, y+d*i++);
		g.drawString("N/A", x, y+d*i++);
		g.drawString(pokemon.speed+"", x, y+d*i++);	
		g.drawString(pokemon.exp+"", x, 490);
		g.drawString(pokemon.expToNextLv()+"", x, 490+d);
		
	}
	
	
	
}
