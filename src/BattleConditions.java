
import java.util.ArrayList;

public class BattleConditions {
		
	ArrayList<Pokemon> playerteam;
	ArrayList<Pokemon> enemyteam;
		
	Pokemon aPkmn;
	Pokemon ePkmn;
	int enemycount =0;
		
	//this should take in and array of pokemon from the player and the enemy
	public BattleConditions(ArrayList<Pokemon> pteam, ArrayList<Pokemon> eteam) {
		this.playerteam = pteam;
		this.enemyteam = eteam;
			
		aPkmn = pteam.get(0);
		ePkmn = eteam.get(0);
			
	}
		
	public BattleConditions() {
		
	}
	
	public void setTeams(ArrayList<Pokemon> pteam, ArrayList<Pokemon> eteam) {
		this.playerteam = pteam;
		this.enemyteam = eteam;
			
		aPkmn = pteam.get(0);
		ePkmn = eteam.get(0);
		
	}
	
	//could write this in the fight method
	public void changedPokeduringbattle() {
		aPkmn.decHp(ePkmn.attack());
	}
		
		
	public void enemyChangePokemon() {
		if(!battlewon() && ePkmn.hp == 0) {
			ePkmn = enemyteam.get(enemycount++);
		}
	}
		
	public void playerChangePokemon() {	
	}
		
	public boolean battlewon() {
		//boolean result = false;
		int count =0;
			
		for(int i = 0; i < enemyteam.size(); i++) {
			if(enemyteam.get(i).hp == 0) {
				count++;
			}
		}
			
		return count == enemyteam.size();
		//dialogue state?
			
	}
		
	public boolean battlelost(){
		//boolean result = false;
		int count = 0;
					
		for(int i = 0; i < playerteam.size(); i++) {
			if(playerteam.get(i).hp == 0) {
				count++;
			}
		}
			
		return count == playerteam.size();
	}
		
		

	public void fight() {
		
		if(aPkmn.speed >= ePkmn.speed) {
//			enemyPokemon.decHp(curPokemon.attack());
			ePkmn.decHp(damageCalculator(aPkmn.lv, aPkmn.moves.get(0).power, aPkmn.attack, ePkmn.defense, 1));
			ePkmn.healthbar();
			
			if(ePkmn.canstillbattle()) {
//				aPkmn.decHp(ePkmn.attack());
				aPkmn.decHp(damageCalculator(ePkmn.lv, ePkmn.moves.get(0).power, ePkmn.attack, aPkmn.defense, 1));
				aPkmn.healthbar();
			}
		}else {
			aPkmn.decHp(damageCalculator(ePkmn.lv, ePkmn.moves.get(0).power, ePkmn.attack, aPkmn.defense, 1));
			aPkmn.healthbar();
			
			if(aPkmn.canstillbattle()) {
				ePkmn.decHp(damageCalculator(aPkmn.lv, aPkmn.moves.get(0).power, aPkmn.attack, ePkmn.defense, 1));
				ePkmn.healthbar();
			}
		}		
	}
	
	private int damageCalculator(int lv, int power, 
			int attack, int defense, int mod) {
		int damage = ((((((2 * lv) / 5) + 2) 
				* power * (attack / defense)) / 50) + 2) * mod;
		
		
		return damage;
	}
	
}