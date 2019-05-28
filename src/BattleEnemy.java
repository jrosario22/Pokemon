
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


public class BattleEnemy{
	
	Image pic;
	Image resize;
	
	static String[] enemies = {"Red", "Leaf", "Bug", "Murphy"};
	static Pokemon[][] pokemonTeam = new Pokemon[6][9];
	int enemyLocation;
	boolean stopped = false;
	
	ArrayList<Pokemon> team = generatePokemons();
		
	public BattleEnemy(int enemyNum){
		pic = Toolkit.getDefaultToolkit().getImage(chooseEnemy(enemyNum));
		resize = pic.getScaledInstance(130, 250, Image.SCALE_DEFAULT);
		enemyLocation = -420;
	}
	
	protected static String chooseEnemy(int enemyNum) {
		String chosenEnemy = "EnemyTrainer" + enemies[enemyNum] + ".png";
		return chosenEnemy;
	}
	
	protected int battlePlacement(){
		if(enemyLocation < 800) {
			return enemyLocation += 10;
		}else{
			stopped = true;
			return (enemyLocation = 800);
		}	
	}
	
	protected boolean isStopped(){
		return stopped;
	}
	
	
	public void draw(Graphics g){
		g.drawImage(resize, enemyLocation, 50, null);
	}
	
	protected void pokeTeam() {
		for(int i = 0; i < pokemonTeam.length; i++){
			
		}
	}

	public int leavePlacement() {
		if(enemyLocation < 1500) {
			return enemyLocation += 10;
		}else{
			stopped = true;
			return (enemyLocation = 1500);
		}
	}
	
	
	private ArrayList<Pokemon> generatePokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		
		//the current hp is 212
		Pokemon pikachu = new Pokemon("pikachu", 5);
		pikachu.learnMove(new Move(MoveType.CUT));
		pikachu.learnMove(new Move(MoveType.ACID));
		pikachu.learnMove(new Move(MoveType.SURF));
		pikachu.learnMove(new Move(MoveType.FLASH));
		pokemons.add(pikachu);
		
		pokemons.add(new Pokemon("charmander", 212,7, 200, 25, 13));
		//pokemons.add(new Pokemon("pidgeotto", 212,5, 25, 25, 10));
		//pokemons.add(new Pokemon("pikachu", 212,5, 25, 25, 10));
		//pokemons.add(new Pokemon("squirtle", 212,5, 25, 25, 10));
		
		return pokemons;
	}
	
	
}
	