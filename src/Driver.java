import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;



import java.applet.Applet;

public class Driver extends Applet implements Runnable, KeyListener, MouseListener
{

	int mouseX;
	int mouseY;
	
	//Animation an = new Animation("p_dn", 4, 10);
	//Pokemon poke = new Pokemon(100, 500,"charmander_back.png",20,5,10,10,5);
	Pokemon poke = new Pokemon("pidgey",20,5,10,10,5);
	//ControlManager control = new ControlManager();
	Pokemon enemypoke = new Pokemon("bulbasaur", 20);
	Image offscreeng;
	Graphics offscreen_g;
	
	//object states of the game
	NPC npc = new NPC(500, 500);
	//NPC npcplayer = new NPC(500, 200);
	Player player = new Player(500,200);
	ArrayList<Pokemon> pokemons = player.trainer.team;	
	OptionMenu menu = new OptionMenu();
	Bag bag = new Bag();
	StatsPage statsPage = new StatsPage();
	MovesPage movesPage = new MovesPage();
	PokemonParty pokemonParty = new PokemonParty(pokemons);
	//BattleConditions bc = new BattleConditions();
	
	//multiple constructures for npc or no npc
	//BattleMain bm = new BattleMain(player.trainer, npc.trainer);
	///BattleMain bm = new BattleMain();
	//ControlManager control = new ControlManager(menu, bag, pokemonParty, statsPage, movesPage, bm.bm);
	//ControlManager control = new ControlManager(menu, bag, pokemonParty, statsPage, movesPage, bm.bm);
	
	
	GrassField patch = new GrassField();
	GrassField patch3 = new GrassField(150, 200);
	
	MusicPlayer audio = new MusicPlayer("idletheme", "Battle!" );
	//MusicPlayer audio = new MusicPlayer("Battle!");
	
	
	//////////REPLACMENT FOR BATTLE MENU
	//setMAtch for battlecodntions
	BattleConditions conditions = new BattleConditions();
	BattleStage		bs = new BattleStage(3);
	BattleText    	bx = new BattleText();
	//BattleMenu bm = new BattleMenu(moves, conditions);
	
	int 	stateCounter 	= 0;
	boolean standoff 		= false;
	boolean menuu 			= false;
	int 	delay 			= 250;
	boolean summoned 		= false;
	String[] moves = new String[4];
	BattleMenu bm = new BattleMenu(moves, conditions);
	ControlManager control = new ControlManager(menu, bag, pokemonParty, statsPage, movesPage, bm);

	BattleTrainer 	bt;
	BattleEnemy   	be;
	Pokemon b1 ;
	Pokemon b2;
	

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
			menuu = true;
		}
		
		
//		System.out.println("sT: " + stateCounter);
//		System.out.println("delay3: " + delay);
	}
	
	
	
	//////////REPLACEMENT FOR BATTLEMENU
	//Player p = new Player(100,100);
	Background bg  =  new Background(0,0,0,"map.png");
	
	//NPC npc = new NPC(500, 500);
	//NPC npcplayer = new NPC(500, 200);
	//Player player = new Player(500,200);
	//Rect rr1 = new Rect(500, 200, 30, 30);
	//BadRect evil = new BadRect(300,300,50, 50);
	//Soldier soldier = new Soldier(100, 100);
	//BattleLord bl = new BattleLord(130, 80);
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	boolean  A_pressed = false;
	boolean  S_pressed = false;
	boolean  W_pressed = false;
	
	
	String x = NPC.poses[0];
	
	Thread t;
	Thread musicthread;

	
	public void init()
	{
		//1000, 600
		
		//offscreeng = this.createImage(5000,2000);
		offscreeng = this.createImage(1200,700);
		offscreen_g = offscreeng.getGraphics();
		 
		//ThreadPool pool = new ThreadPool(2);

	    Frame title = (Frame)this.getParent().getParent();
	    title.setTitle("Pokemon");
	    //
	   
		this.setSize(1200, 700);
		
		title.setMenuBar(null);
		requestFocus();
		
		addKeyListener(this);
		addMouseListener(this);
		//addKeyListener(menu);
		//addKeyListener(menu.bag);
		addKeyListener(control);
		
		
		
		t = new Thread(this);
		musicthread = new Thread(audio);
		//battlemusic = new Thread(audio);
		//musict = new Thread(idlesound);
		
		t.start();
		musicthread.start();
		//battlemusic.start();
		
		
		
	
		
	}
	

	
	public void update(Graphics g) {
		
		//offscreen_g.clearRect(0, 0, 5000, 2000);
		offscreen_g.clearRect(0, 0, 1200, 700);
		paint(offscreen_g);
		
		//g.drawImage(offscreeng, 0,0, 5000, 2000, null);
		g.drawImage(offscreeng, 0,0, 1200, 700, null);
		
		
		
	}
	
	public void run()
	{
		//ball.setVelocity(4, 15);
		while(true)
		{
					
			
			if(GameState.isIdle()) {
				//music();
			
			if(up_pressed)   Camera.moveUp(3);
			if(dn_pressed)   Camera.moveDown(3);
			if(lt_pressed)	 Camera.moveLeft(3);
			if(rt_pressed)	 Camera.moveRight(3);
			
			if(up_pressed) {
				player.moveUp(3); 
				//patch.moveUp(3);
			}
			if(dn_pressed) {
				player.moveDown(3);
				//patch.moveDown(3);
			}
			if(lt_pressed)   player.moveLeft(3); 
			if(rt_pressed)   player.moveRight(3);
			
			}
			///grass patch
			
			/*
			if(patch.containss(player) && player.moving && randomchance()) {
				GameState.setState(GameState.battle);
				//playanimation
				System.out.println(" i see player");
			}
			
			if(patch3.containss(player) && player.moving && randomchance()) {
				GameState.setState(GameState.battle);
				//332344System.out.println("");
			}
			*/
			
			
			//music();
			
			//if(p.x >500 && p.y <300) {
				//rr1.chases();
				//evil.moveDownBy(10);
			//}
			
			//r1.draw(g);
			//if you want him to stop after the battle add a boolean to check whether this npc battles
			//or not and add that to the condition for the npc to move
			//consider which side the npc is facing...so make a function
			//if(npc.r1.overlapss(npcplayer) & npc.y - 50 >= npcplayer.y) {
			//maybe upgrade this based on collison detection
			
			
			if(npc.rUp.overlapss(player) && npc.ishouldstop(player.x, player.y)) {
				//System.out.println("i should stop the player!!");
				
				npc.moveUp(2);
			}
				if(npc.rLeft.overlapss(player) &&npc.ishouldstop(player.x, player.y)){
					npc.moveLeft(2);
				}
				
				if(npc.rRight.overlapss(player) && npc.ishouldstop(player.x, player.y)) {
					npc.moveRight(2);
					System.out.println("hey there");
				}
				

				if(npc.box.overlapss(player) && npc.hasBattled) {
					//bm.setMatch(player.trainer, npc.trainer);
					bt = player.trainer;
					be = npc.trainer;
					b1 = player.trainer.team.get(0);
					b2 = npc.trainer.team.get(0);
					
					
					GameState.setState(GameState.battle);
					moveWriter();
					conditions.setTeams(player.trainer.team, npc.trainer.team);
					stateChanger();
					//System.out.println("i touched the player");
					
				}
				//bm.setMatch(player.trainer, npc.trainer);
				
			
	
			repaint();
			
			try
			{
				//System.out.println("ryan is driving");
			   t.sleep(16);
			   //musicthread.sleep(16);
			}
			catch(Exception x) {};
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_A)      A_pressed  = true;
		if (e.getKeyCode() == KeyEvent.VK_S)      S_pressed  = true;
		if (e.getKeyCode() == KeyEvent.VK_W)      W_pressed  = true;
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_A)      A_pressed  = false;
		if (e.getKeyCode() == KeyEvent.VK_S)      S_pressed  = false;
		if (e.getKeyCode() == KeyEvent.VK_W)      W_pressed  = false;
		
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public boolean randomchance() {
		int x = (int) (Math.random()*50);
		int num = (int)Math.random()* 70;
		
		
		if(x == 20 || num == 50) {
			return true;
		}else {
			return false;
		}
		
		
		
	} 
	
	/*
	public void flicker() {
		for(int i = 2000; i>0; i--) {
			
		}
		
	}*/
	
	public void paint(Graphics g){
		
		//Graphics g2d = (Graphics2D) g;
		//g2d.translate((int)-Camera.x,(int) -Camera.y);
		
		
		//bag.draw (g);
		/*if(GameState.isOption()) {
			//GamePick.setState();
			menu.draw(g);
		}*/
		
		//could just have the bag options in the driver instead then
		
		if(GameState.isBattle()) {	
			bs.draw(g);
			bx.draw(g);
			bt.draw(g);  
			be.draw(g);
			
			if(summoned){
				
				
				b1.drawhp(g);
				b2.drawhp(g);
				b1.draw(g);
				b2.draw(g);
				
				//pokemons().get(0).drawhp(g);
				//pokemons().get(0).draw(g);
				///enemyPokemons().get(0).drawhp(g);
				//enemyPokemons().get(0).draw(g);
			}
			if(menuu){
				bm.draw(g);
			}
			
			//bm.paint(g);
			//poke.drawhp(g);
			//enemypoke.drawhp(g);
			//poke.draw(g);
			//enemypoke.draw(g);
			//npc.trainer.team.get(0).drawhp(g);
			//npc.trainer.team.get(0).draw(g);
			
			//player.trainer.team.get(1).drawhp(g);
			//player.trainer.team.get(1).draw(g);
			
				
					//g.setColor(Color.black);
					//g.fillRect(0, 0, 1200, 700);
					//g.drawRect(0, 0, 1200, 700);
			//bm.paint(g);
			
			
			
		}
		
		
		if(GameState.isBag()) {
			bag.drawItems(g);
		}
		
		
		if(GameState.isIdle()) {
			bg.draw(g);
			player.draw(g);
			patch.draw(g);
			patch3.draw(g);
			//poke.draw(g);
			//music();
			npc.draw(g);
			//npc.rUp.draw(g);
			//npc.rRight.draw(g);
			npc.box.draw(g);
			//menu.draw(g);
		}
		
		if(GameState.isOption()) {
			bg.draw(g);
			player.draw(g);
			//npc.draw(g);
			menu.draw(g);
		}
		
		
		if (GameState.isPokemon() || GameState.isPokemonsOption()) {
			pokemonParty.draw(g);
		}
		else if (GameState.isStats()) {
			statsPage.draw(g);
		}
		else if (GameState.isMoves()) {
			movesPage.draw(g);
		}
		
		
		
		
		g.drawString("(" + mouseX + ", " + mouseY + ")", mouseX, mouseY);
		
		
		
			
	}
	
	/*
	private ArrayList<Pokemon> generatePokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		Pokemon bulbasaur = new Pokemon("bulbasaur", 212, 5 ,25, 25, 10);
		bulbasaur.learnMove(new Move(MoveType.CUT));
		bulbasaur.learnMove(new Move(MoveType.ACID));
		bulbasaur.learnMove(new Move(MoveType.SURF));
		bulbasaur.learnMove(new Move(MoveType.FLASH));
		pokemons.add(bulbasaur);
		
		pokemons.add(new Pokemon("charmander", 212,7, 200, 25, 13));
		//pokemons.add(new Pokemon("pidgeotto", 212,5, 25, 25, 10));
		pokemons.add(new Pokemon("pikachu", 212,5, 25, 25, 10));
		//pokemons.add(new Pokemon("squirtle", 212,5, 25, 25, 10));
		
		return pokemons;
	}*/



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX(); 
		mouseY = e.getY();
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}