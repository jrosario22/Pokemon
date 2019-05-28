
public class EnemyNPC{

	int x;
	int y;
	String name;
	String title;
	
	String[] names = {"Bob", "Tai", "Susie", "Julie", "Brian Murphy"};
	String[] titles = {"Sideshow", "Bugcatcher", "Saidewalk", "PokElite", "Master of the Universe"};
	
	String[][] enemyTeam = {
			{"squirtle"}
			};
	int[] enemyTeamLv = {7};
	
	public EnemyNPC(int x, int y) {
		this.x = x;
		this.y = y;
		name = names[(int)(4 * Math.random())];
		title = titles[(int)(4 * Math.random())];
	}
	

	
}