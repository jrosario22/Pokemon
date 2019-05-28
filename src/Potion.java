
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Potion
{
	PokemonParty party;
	int increaseHp;
	
 	/*// Gets bag image
 	Image normPotion = Toolkit.getDefaultToolkit().getImage("NormalPotion.png");
 	Image superPotion = Toolkit.getDefaultToolkit().getImage("SuperPotion.png");
 	*/
 	
	public Potion(PokemonParty party, int increaseHp)
	{
		this.party = party;
		this.increaseHp = increaseHp;

	}
	
	public Potion(int increaseHP) {
		this.increaseHp = increaseHp;
	}

	public void usePotion()
    {
	party.getCurrentPokemon().incHp(increaseHp);
    }
	
	/*// Potion Graphic
	public void draw(Graphics g)
	{
		g.drawImage(potions, 0, 0, null);
	}
	*/	
	
}
