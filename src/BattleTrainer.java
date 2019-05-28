
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class BattleTrainer{

	Image pic;
	Image resize;
	
	static String[] trainers = {"Red"};
	int trainerLocation;
	boolean stopped = false;
	
	static int[] pose = new int[5];
	static int curPose;
	ArrayList<Pokemon> team = generatePokemons();
	
	
	public BattleTrainer(int trainerNum) {
		pic = Toolkit.getDefaultToolkit().getImage(chooseTrainer(trainerNum));
		
		for(int i = 0; i < pose.length; i++) {
			pose[i] = i;
		}
		
		resize = pic.getScaledInstance(200, 225, Image.SCALE_DEFAULT);
		trainerLocation = 1450;
		curPose = 0;
	}

	private static String chooseTrainer(int trainerNum) {
		String chosenTrainer = "Trainer" + trainers[trainerNum] + "Back_" + curPose + ".png";
		return chosenTrainer;
	}
	
	
	public void draw(Graphics g){
		g.drawImage(resize, trainerLocation, 275, null);
	}
	
	protected int battlePlacement(){
		if(trainerLocation > 230) {
			return trainerLocation -= 10;
		}else{
			stopped = true;
			return (trainerLocation = 230);
		}
	}
	
	protected boolean isStopped(){
		return stopped;
	}

	public int leavePlacement() {
		
		if(trainerLocation > -300) {
			return trainerLocation -= 10;
		}else{
			stopped = true;
			return (trainerLocation = -300);
		}
		
	}
	
	private ArrayList<Pokemon> generatePokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		
		//the current hp is 212
		Pokemon bulbasaur = new Pokemon("bulbasaur", 212, 5 ,25, 25, 10);
		bulbasaur.learnMove(new Move(MoveType.CUT));
		bulbasaur.learnMove(new Move(MoveType.ACID));
		bulbasaur.learnMove(new Move(MoveType.SURF));
		bulbasaur.learnMove(new Move(MoveType.FLASH));
		pokemons.add(bulbasaur);
		
		pokemons.add(new Pokemon("charmander", 212,7, 200, 25, 13));
		pokemons.add(new Pokemon("pidgeotto", 212,5, 25, 25, 10));
		pokemons.add(new Pokemon("pikachu", 212,5, 25, 25, 10));
		pokemons.add(new Pokemon("squirtle", 212,5, 25, 25, 10));
		
		return pokemons;
	}

	
	
}