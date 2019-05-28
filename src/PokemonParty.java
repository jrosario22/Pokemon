import java.awt.*;
import java.util.*;

class PokemonParty {
	
	private ArrayList<Pokemon> pokemons;
	
	private Image backgroundImage = Toolkit.getDefaultToolkit().getImage("../image/pokemonparty.png");
	private Image cancelBarImage = Toolkit.getDefaultToolkit().getImage("../image/cancelbar.png");
	private Image firstPokeBarImage = Toolkit.getDefaultToolkit().getImage("../image/firstpokebar.png");
	private Image pokeBarImage = Toolkit.getDefaultToolkit().getImage("../image/pokebar.png");
	private Image SelectedCancelBarImage = Toolkit.getDefaultToolkit().getImage("../image/selected_cancelbar.png");
	private Image SelectedFirstPokeBarImage = Toolkit.getDefaultToolkit().getImage("../image/selected_firstpokebar.png");
	private Image SelectedPokeBarImage = Toolkit.getDefaultToolkit().getImage("../image/selected_pokebar.png");
	
	private Font descriptionFont = new Font(Font.SANS_SERIF, Font.PLAIN, 36);
	private Font pokeFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	
	private int selected = 0;	
	private int switchIndex = -1;
	private boolean switchMode = false;
	private PokemonsOption pokemonsOption = new PokemonsOption();
	
	
	public PokemonParty (ArrayList<Pokemon> pokemons) {
		
		this.pokemons = pokemons;

	}
	
	public PokemonParty () {
		pokemons = new ArrayList<Pokemon>();
	}
	
	public void addPokemon (Pokemon p) {
		if(pokemons.size() < 6) {
			pokemons.add(p);
		}
	}
	
	public Pokemon getCurrentPokemon(){
		return pokemons.get(0);
	}
	
	public Pokemon getSelectedPokemon() {
		return pokemons.get(selected);
	}
	
	public void revertSelected () {
		if (switchIndex != -1) {
			selected = switchIndex;
		}
	}
	
	
	public void moveLeft() {
		if (selected == pokemons.size() && pokemons.size() > 1) {
			selected = 1;
		}
		else {
			selected = 0;
		}
	}
	
	public void moveRight() {
		if (selected == 0) {
			selected++; 
		}
		else if (selected < pokemons.size()) {
			selected = pokemons.size();
		}
	}
	
	public void moveUp() {
		if (selected > 0) {
			selected--;
		}		
	}
	
	public void moveDown() {
		if (selected < pokemons.size()) {
			selected++;
		}
	}
	
	public PokemonsOption getOptions() {
		return pokemonsOption;
	}
	
	public boolean isCancel() {
		return selected == pokemons.size();
	}
	
	public void reset() {
		selected = 0;
	}
	
	public boolean isSwitchMode() {
		return switchMode;
	}
	
	public void setSwitchMode(boolean mode) {
		switchMode = mode;
	}
	
	public void setSwitchIndex() {
		switchIndex = selected;
		selected = (selected+1) % pokemons.size();
	}
	
	public void switchPokemon() {
		if (selected < pokemons.size() && switchIndex != selected) {
			Collections.swap(pokemons, switchIndex, selected);	
			revertSelected();
		}	
	}
	
	
	public void draw (Graphics g) {
		g.drawImage(backgroundImage, 0, 0, 1200, 700, null);
		
		// draw pokemons
		
		for (int i = 0; i < pokemons.size(); i++) {
				Pokemon pokemon = pokemons.get(i);
				if (i == 0) {
					g.setFont(pokeFont);
					g.setColor(Color.WHITE);
					if (i == selected || (switchMode && i == switchIndex)) {
						g.drawImage(SelectedFirstPokeBarImage, 10, 85, 420, 240, null);
					}
					else {
						g.drawImage(firstPokeBarImage, 10, 85, 420, 240, null);
					}
					g.drawImage(pokemon.image, -10, 60, 150, 150, null);
					g.drawString(pokemon.name, 150, 200);
					g.drawString(pokemon.lv+"", 250, 240);
					g.drawString(pokemon.hp+"", 235, 310);
					g.drawString(pokemon.hpMax+"", 335, 310);
					
					g.setColor(Color.green);
					int hpBarLength = 240 * pokemon.hp / pokemon.hpMax;
					g.fillRect(160, 260, hpBarLength, 10);
				}
				else {
					int x = 430; 
					int y = 40 + (i-1) * 105;
					g.setFont(pokeFont);
					g.setColor(Color.WHITE);
					if (i == selected || (switchMode && i == switchIndex)) {
						g.drawImage(SelectedPokeBarImage, x, y, 760, 105, null);
					}
					else {
						g.drawImage(pokeBarImage, x, y, 760, 95, null);
					}
					g.drawImage(pokemon.image, x, y, 100, 100, null);
					g.drawString(pokemon.name, x+120, y+50);
					g.drawString(pokemon.lv+"", x+260, y+85);
					g.drawString(pokemon.hp+"", x+560, y+85);
					g.drawString(pokemon.hpMax+"", x+670, y+85);
					
					g.setColor(Color.green);
					int hpBarLength = 245 * pokemon.hp / pokemon.hpMax;
					g.fillRect(x+485, y+36, hpBarLength, 11);
				}
		}
			
		// draw cancel bar
		if (selected == pokemons.size()) {
			g.drawImage(SelectedCancelBarImage, 920, 565, 270, 110, null);
		}
		else {
			g.drawImage(cancelBarImage, 960, 570, 230, 100, null);
		}
			
			
		if (GameState.isPokemonsOption()) {
			// draw options
			pokemonsOption.draw(g);
		}
		
		g.setFont(descriptionFont);
		g.setColor(Color.BLACK);
		g.drawString("Choose a Pokemon.", 40, 630);
		
		
		
	}
	
	
	
	
	

}