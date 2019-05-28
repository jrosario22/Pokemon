import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlManager implements KeyListener{
//	GameState state = GameState.getState();
//	OptionMenu menu = new OptionMenu();
	OptionMenu menu;
	Bag bag;
	PokemonParty pokemonParty;
	PokemonsOption pokemonsOption;
	StatsPage statsPage;
	MovesPage movesPage;
	BattleMenu bM;
	
	public ControlManager(OptionMenu menu, Bag bag,PokemonParty pokemonParty, StatsPage statsPage, MovesPage movesPage, BattleMenu bm) {
		this.menu         = menu;
		this.bag          = bag;
		this.pokemonParty = pokemonParty;
		this.statsPage    = statsPage;
		this.movesPage    = movesPage;
		pokemonsOption    = pokemonParty.getOptions();
		this.bM = bm;
	}
	
//	public ControlManager() {
//	
//	}
	
	
	//the controls when you're in the menu/option state
	private void optionControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		switch(keycode) {
		case KeyEvent.VK_UP:
			menu.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			menu.moveDown();
			break;
		case KeyEvent.VK_BACK_SPACE:
			GameState.setState(GameState.idle);
			break;
		case KeyEvent.VK_ENTER:
			switch(menu.getIndex()) {
			case 0:
				GameState.setState(GameState.mypokemon);
				break;
			case 1:
				GameState.setState(GameState.bag);
				break;
			case 2:
				//currently does nothing
				break;
			case 3:
				GameState.setState(GameState.idle);
			}
		
		}
		
	}
	
	//for when the player is allowed to move around in the world
	private void idleControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		switch(keycode) {
		case KeyEvent.VK_ENTER:
			GameState.setState(GameState.option);
			break;
		}
	}
	
	//controls for the bag state
	private void bagControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		switch(keycode) {
		case KeyEvent.VK_BACK_SPACE:
			GameState.setState(GameState.option);
			break;
		case KeyEvent.VK_UP:
			bag.moveUp();
			break;
	
		case KeyEvent.VK_DOWN:
			bag.moveDown();
			break;	
			
		case KeyEvent.VK_LEFT:
			bag.moveLeft();
			break;
	
		case KeyEvent.VK_RIGHT:
			bag.moveRight();
			break;		
		}
	}
	
	//controls for the pokemon party state
	private void mypokemonControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (!pokemonParty.isSwitchMode()) {
			switch(keycode) {
			case KeyEvent.VK_BACK_SPACE:
				GameState.setState(GameState.option);
				pokemonParty.reset();
				break;
			case KeyEvent.VK_ENTER:
				if (pokemonParty.isCancel()) {
					GameState.setState(GameState.option);
					pokemonParty.reset();
				}
				else {
					GameState.setState(GameState.pokemonsOption);
				}
				break;
			case KeyEvent.VK_UP:
				pokemonParty.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				pokemonParty.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				pokemonParty.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				pokemonParty.moveRight();
				break;
			}
		}
		else { // in switching mode
			switch(keycode) {
			case KeyEvent.VK_BACK_SPACE:
				pokemonParty.setSwitchMode(false);
				pokemonParty.revertSelected();
				GameState.setState(GameState.pokemonsOption);
				break;
			case KeyEvent.VK_ENTER:
				if (pokemonParty.isCancel()) {
					GameState.setState(GameState.option);
					pokemonParty.reset();
				}
				else {
					pokemonParty.switchPokemon();
					pokemonParty.setSwitchMode(false);
					GameState.setState(GameState.pokemonsOption);
				}
				break;
			case KeyEvent.VK_UP:
				pokemonParty.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				pokemonParty.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				pokemonParty.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				pokemonParty.moveRight();
				break;
			}
		}
	
		
	}
	
	private void pokemonsOptionControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode) {
		case KeyEvent.VK_BACK_SPACE:
			GameState.setState(GameState.mypokemon);
			pokemonsOption.reset();
			break;
		case KeyEvent.VK_UP:
			pokemonsOption.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			pokemonsOption.moveDown();
			break;
		case KeyEvent.VK_ENTER:
			switch(pokemonsOption.getIndex()) {
				case 0:
					statsPage.setPokemon(pokemonParty.getSelectedPokemon());
					movesPage.setPokemon(pokemonParty.getSelectedPokemon());
					GameState.setState(GameState.stats);
					break;
				case 1:
					pokemonParty.setSwitchMode(true);
					pokemonParty.setSwitchIndex();
					GameState.setState(GameState.mypokemon);
					break;
				case 2:
					GameState.setState(GameState.bag);
					break;
				case 3:
					GameState.setState(GameState.mypokemon);
					pokemonsOption.reset();
					break;
			}
			break;			
		}
	}
	
	public void statsControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode) {
		case KeyEvent.VK_BACK_SPACE: 
			GameState.setState(GameState.pokemonsOption);
			break;
		case KeyEvent.VK_RIGHT: 
			GameState.setState(GameState.moves);
		}
	}
	
	public void movesControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode) {
		case KeyEvent.VK_BACK_SPACE: 
			GameState.setState(GameState.pokemonsOption);
			break;
		case KeyEvent.VK_LEFT: 
			GameState.setState(GameState.stats);
			break;
		}

		
	}
	
	private void battleControls(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		switch(keycode) {
		case KeyEvent.VK_LEFT:
			bM.moveArrowLeft();
			System.out.println("Ayyyyy");
			break;
		case KeyEvent.VK_RIGHT:
			bM.moveArrowRight();
			System.out.println("Nayyyyy");
			break;
//		case KeyEvent.VK_UP:
//			bM.moveArrowLeft();
//			System.out.println("Ayyyyy");
//			break;
//		case KeyEvent.VK_DOWN:
//			bM.moveArrowLeft();
//			System.out.println("Ayyyyy");
//			break;
			
		case KeyEvent.VK_Z:
			bM.pressZ();
			
			System.out.println("Ayyyyy");
			break;
		case KeyEvent.VK_X:
			bM.pressX();
			
			System.out.println("Nayyyyy");
			break;
		}
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		////if (e.getKeyCode() == KeyEvent.VK_UP) menu.moveUp();
		//int keycode = e.getKeyCode();
		
		GameState state = GameState.getState();
		
		switch(state) {
		case option:
			optionControls(e);
			break;
		case idle:
			idleControls(e);
			break;
		case bag:
			bagControls(e);
			break;
		case mypokemon:
			mypokemonControls(e);
			break;
		case pokemonsOption:
			pokemonsOptionControls(e);
			break;
		case stats:
			statsControls(e);
			break;
		case moves:
			movesControls(e);
			break;
		case battle:
			battleControls(e);
			break;
				
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

}

