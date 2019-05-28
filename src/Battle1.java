
public class Battle1 {
	
	Pokemon[] playerteam;
	Pokemon[] enemyteam;
	
	Pokemon curPokemon;
	Pokemon enemyPokemon;
	int enemycount =0;
	
	//this should take in and array of pokemon from the player and the enemy
	public Battle1(Pokemon[] pteam, Pokemon[] eteam) {
		this.playerteam = pteam;
		this.enemyteam = eteam;
		
		curPokemon = pteam[0];
		enemyPokemon = eteam[0];
		
	}
	
	//could write this in the fight method
	public void changedPokeduringbattle() {
		curPokemon.decHp(enemyPokemon.attack());
		
	}
	
	
	public void enemyChangePokemon() {
		if(!battlewon() && enemyPokemon.hp == 0) {
			enemyPokemon = enemyteam[enemycount++];
			
		}
		
	}
	
	public void playerChangePokemon() {
		
	}
	
	
	
	
	public boolean battlewon() {
		//boolean result = false;
		int count =0;
		
		for(int i = 0; i < enemyteam.length; i++) {
			if(enemyteam[i].hp == 0) {
				count++;
			}
		}
		
		return count == enemyteam.length;
		//dialogue state?
		
	}
	
	public boolean battlelost() {
		//boolean result = false;
		int count = 0;
		
		
		
		for(int i = 0; i < playerteam.length; i++) {
			if(playerteam[i].hp == 0) {
				count++;
			}
		}
		
		return count == playerteam.length;
	}
	
	

	public void fight() {
		if(curPokemon.speed >= enemyPokemon.speed) {
			enemyPokemon.decHp(curPokemon.attack());
			if(enemyPokemon.canstillbattle()) {
				curPokemon.decHp(enemyPokemon.attack());
			}
			
		}else {
			curPokemon.decHp(enemyPokemon.attack);
			if(curPokemon.canstillbattle()) {
				enemyPokemon.decHp(curPokemon.attack());
			}
		}
		
	}
	
	

}
