
public enum GameState {
	
	
	//test enum vs class
	idle, battle, mypokemon, bag, option, pokemonsOption, stats, moves;
	
	

	
	private static GameState current = idle;
	 
	 static void setState(GameState newstate) {
		 current = newstate;
		 
	 }
	 
	 static GameState getState() {
		 return current;
	 }
	 
	 static boolean isIdle() {
		 
		 return current == idle;
	 }
	 
	 static boolean isBag() {
		 
		 return current == bag;
	 }
 
	 static boolean isBattle() {
	 
	 return current == battle;
	 }
	
	 
	 static boolean isOption() {
		 
		 return current == option;
	 }
	 
	 static boolean isPokemon() {
		 
		 return current == mypokemon;
	 }
	//GameState type = GameState.idle;
	
	 static boolean isPokemonsOption() {
		 
		 return current == pokemonsOption;
	 }
	 
	 static boolean isStats() {
		 
		 return current == stats;
	 }
	 
	 static boolean isMoves() {
		 
		 return current == moves;
	 }


}