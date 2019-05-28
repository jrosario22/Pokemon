import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BattleMain implements KeyListener, MouseListener{

	OptionMenu om = new OptionMenu();
	ControlManager controls;

	//Thread t;

	Image offscreenImg;
	Graphics offscreenG;
	
/*
	static Object[][] pokemonIndex = {
			{"bulbasaur", 5, 0, 20, 10, 12, 10, "bulbasaur.png", "bulbasaurBack.png"},
			{"charmander", 5, 0, 18, 12, 10, 12, "charmander.png", "charmanderBack.png"},
			{"squirtle", 5, 0, 20, 10, 14, 8, "squirtle.png", "squirtleBack.png"},
			{"pikachu", 5, 0, 18, 12, 10, 14, "pikachu.png", "pikachuBack.png"},
			{"pidgey", 5, 0, 20, 10, 10, 12, "pidgey.png", "pidgeyBack.png"},
																						};
	*/
	
	
	int 	stateCounter 	= 0;
	boolean standoff 		= false;
	boolean menu 			= false;
	int 	delay 			= 250;
	boolean summoned 		= false;
	String[] moves = new String[4];
	
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	
//	boolean w_pressed = false;
//	boolean s_pressed = false;
//	boolean a_pressed = false;
//	boolean d_pressed = false;
	
	int mouseX, mouseY;
	/*hey future me
	 * you issue might be Pokemon b1..it is currently null
	
	
	
	*/
	
	BattleStage		bs = new BattleStage(3);
	BattleText    	bx = new BattleText();
	//BattleTrainer 	bt = new BattleTrainer(0);
	//BattleEnemy   	be = new BattleEnemy(3);
	BattleTrainer 	bt;
	BattleEnemy   	be;
	//Pokemon b1 = bt.team.get(0);
	Pokemon b1 ;
	Pokemon b2;
	
	/*
	//Pokemon 		b1 = new Pokemon(0, (int)pokemonIndex[0][3], 7, 
								(int)pokemonIndex[0][4], (int)pokemonIndex[0][5],
								(int)pokemonIndex[0][6]);
//	Pokemon 		b2 = new Pokemon(1, 5);
	
	
	*/
	
	/*
	private ArrayList<Pokemon> pokemons() {
        ArrayList<Pokemon> p1 = new ArrayList<Pokemon>();
        
        //int name, int hpMax, int lv, int attack, int defense, int speed
//        Pokemon bulbasaur = new Pokemon(0, (int)pokemonIndex[0][3], 7, (int)pokemonIndex[0][4], (int)pokemonIndex[0][5], (int)pokemonIndex[0][6]);
        b1.learnMove(new Moves(MoveType.TACKLE));
        b1.learnMove(new Moves(MoveType.VINE_WHIP));
        b1.learnMove(new Moves(MoveType.MAGICAL_LEAF));
        b1.learnMove(new Moves(MoveType.RAZOR_LEAF));
        p1.add(b1);

//        pokemons1.add(new Pokemon(0,0,"charmander", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"pidgeotto", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"pikachu", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"squirtle", 212,5, 25, 25, 10));

        return p1;
    }
	
	private ArrayList<Pokemon> enemyPokemons() {
        ArrayList<Pokemon> p2 = new ArrayList<Pokemon>();
        
        //int name, int lv
//        Pokemon charmander = new Pokemon(1, 6);
        b2.learnMove(new BattleMoves(MoveType.SCRATCH));
        b2.learnMove(new BattleMoves(MoveType.BITE));
        b2.learnMove(new BattleMoves(MoveType.EMBER));
        b2.learnMove(new BattleMoves(MoveType.METAL_CLAW));
        p2.add(b2);

//        pokemons1.add(new Pokemon(0,0,"charmander", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"pidgeotto", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"pikachu", 212,5, 25, 25, 10));
//        pokemons1.add(new Pokemon(0,0,"squirtle", 212,5, 25, 25, 10));

        return p2;
    }
	*/
	//BattleConditions bc = new BattleConditions(bt.team, be.team);
	//BattleConditions bc = new BattleConditions();
	BattleConditions bc;
	//BattleConditons bc;
	
	BattleMenu    	bm = new BattleMenu(moves, bc);
	
	
	//have this as a set method instead
	public BattleMain(BattleTrainer trainer, BattleEnemy enemytrainer) {
		// TODO Auto-generated constructor stub
		bt = trainer;
		be = enemytrainer;
		b1 = trainer.team.get(0);
		b2 = enemytrainer.team.get(0);
	}
	
	public BattleMain() {
		
	}

	
	public void setMatch(BattleTrainer trainer, BattleEnemy enemytrainer) {
		bt = trainer;
		be = enemytrainer;
		bc = new BattleConditions(trainer.team, enemytrainer.team);
		
	}
	/*
	public void init(){
		this.setSize(1200, 700);
		requestFocus();
		addKeyListener(this);	
		addMouseListener(this);
		
		GameState.setState(GameState.battle);
		
		controls = new ControlManager(om, bm);
		addKeyListener(controls);
		
		t = new Thread(this);
		t.start();	
		
		offscreenImg = this.createImage(1200, 700);
		offscreenG = offscreenImg.getGraphics();
	}
	*/
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_W)       w_pressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_S)       s_pressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_A)       a_pressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_D)       d_pressed = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_W)       w_pressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_S)       s_pressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_A)       a_pressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_D)       d_pressed = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX(); 
		mouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	private String[] moveWriter() {
		for(int i = 0; i < 4; i++){
//			System.out.println(b1.moves.get(i).moveType.name);
			moves[i] = b1.moves.get(i).moveType.name;
		}		
		
		return moves;
	}
	
	public boolean battleState(){
		boolean tState = bt.isStopped();
		boolean eState = be.isStopped();
		
		standoff = (tState && eState);
		return standoff;
	}
	
	
	/*
	public void update(Graphics g) {
		offscreenG.clearRect(0, 0, 1200, 700);
		paint(offscreenG);
		g.drawImage(offscreenImg, 0, 0, 1200, 700, null);
	}*/
	
	public void paint(Graphics g){
		
		if(GameState.isBattle()){
			bs.draw(g);
			bx.draw(g);
			bt.draw(g);  
			be.draw(g);
			
			/*
			bt.team.get(1).drawhp(g);
			bt.team.get(1).draw(g);
			be.team.get(0).drawhp(g);
			be.team.get(0).draw(g);
			
			/*
			b1.drawhp(g);
			b2.drawhp(g);
			b1.draw(g);
			b2.draw(g);
			*/
			
			if(summoned){
				
				bt.team.get(1).drawhp(g);
				bt.team.get(1).draw(g);
				be.team.get(0).drawhp(g);
				be.team.get(0).draw(g);
				
				//b1.drawhp(g);
				//b2.drawhp(g);
				//b1.draw(g);
				//b2.draw(g);
			}
			if(menu){
				bm.draw(g);
			}
			

		}
		
		
//		bs.draw(g);
//		bx.draw(g);
//		bt.draw(g);  
//		be.draw(g);
		
		//if(menu){
			//bm.draw(g);
		//}
		
		g.drawString("(" + mouseX + ", " + mouseY + ")", mouseX, mouseY);
		
	}
	
	public void stateChanger() {
		
		//STATE 0
		if(battleState() == false && stateCounter == 0) {
			bt.battlePlacement();
			be.battlePlacement();
//			System.out.println(stateCounter);
		}else if(battleState() == true && stateCounter == 0){
			stateCounter++;
//			System.out.println("sT2: " + stateCounter);
		}
		
//		System.out.println(delay);
		//STATE 1
		if(stateCounter == 1 && delay > 0) {
			bt.stopped= false;
			be.stopped= false;
			delay -=5;
//			System.out.println("delay1: " + delay);
		}else if(stateCounter == 1 && delay == 0 && battleState() == false) {
			bt.leavePlacement(); 
			be.leavePlacement();
//			System.out.println("sT3: " + stateCounter);
//			System.out.println("delay2: " + delay);
		}else if(stateCounter == 1 && delay == 0 && battleState() == true) {
			stateCounter++;
			summoned = true;
//			System.out.println("sT3: " + stateCounter);
			
			//System.out.println("delay2: " + delay);
		}
		
		//STATE 2
		if(stateCounter == 2) {
			menu = true;
		}
		
		
//		System.out.println("sT: " + stateCounter);
//		System.out.println("delay3: " + delay);
	}
	/*
	public void run(){
//		bs.chooseStage(2);
//		bt.chooseTrainer(0);
//		be.chooseEnemy(0);
		moveWriter();
		
		while(true){
			
			stateChanger();
			
			
			repaint();
			
			try{
				   t.sleep(16);
				}
				catch(Exception e) {};
		}
	}
	*/
	
}