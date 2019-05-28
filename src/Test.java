import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Test {
	
//	SimpleSoundPlayer idlesound = new SimpleSoundPlayer("audio/idletheme.wav");
//	 // create the stream to play
//	 InputStream stream =new ByteArrayInputStream(idlesound.getSamples());
//	
//	 
//	 public void wtf() {
//		 
//		 idlesound.play(stream);
//		 System.exit(0);
//	 }
	Battle1 battle;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String filepath = "wildpokemon.mp3";
		
		
		//Sound sound = new Sound("audio/Battle!.wav");
		//sound.play();
		//sound.loop();
		//sound.playMusic("wildpokemon.mp3");
		//g.printthis();
		//Audio s = new Audio();
		//s.playSound("audio/Battle!.wav");
		
		//SimpleSoundPlayer idlesound = new SimpleSoundPlayer("audio/idletheme.wav");
		 // create the stream to play
		 //InputStream stream =new ByteArrayInputStream(idlesound.getSamples());
		 // play the sound
		 //Test t = new Test();
		
		Pokemon [] team1 = new Pokemon [3];
		Pokemon [] team1 = new Pokemon [3];
		
		team1[0] = new Pokemon(100,500, "charmender",25,5,10,10,5);
		team1[1] = new Pokemon(100,500, "pikachu",20,5,10,10,5);
		team1[2] = new Pokemon(100,500, "squrtle",20,5,10,10,5);
		
		
		/*
		Pokemon[] team2 = new Pokemon[3];
		team2[0] = new Pokemon(100,500, "Treeko",0,5,10,10,5);
		team2[1] = new Pokemon(100,500, "pidgey",0,5,10,10,5);
		team2[2] = new Pokemon(100,500, "Snorlax",0,5,10,10,5);
		
		
		Battle1 battle = new Battle1(team1, team2);
		*/
		
		System.out.println("it is " + team1[0].hp);
		team1[0].incHp(30);
		System.out.println("it is " + team1[0].hp);
		
		
		//System.out.println("player won result is " );
		
		
		
		
		/*
		Pokemon x = new Pokemon(100, 500,"charmander_back.png",20,5,10,10,5);
		Pokemon y = new Pokemon(100, 500,".png",20,5,10,10,5);
		//battle = new Battle1(x, y);
		Battle1 wtf = new Battle1(x, y);
		
		System.out.println("player hp" + x.hp);
		System.out.println("enemy hp" + y.hp);
		wtf.fight();
		
		//x.decHp(y.attack);
		
		//battle.fight();
		
		System.out.println("player hp" + x.hp);
		System.out.println("enemy hp" + y.hp);
		
		wtf.fight();
		
		//x.decHp(y.attack);
		
		//battle.fight();
		
		System.out.println("player hp" + x.hp);
		System.out.println("enemy hp" + y.hp);
		*/
		
		//System.out.println(charmender.hp - enemy.attack);
		// t.wtf();
		 
		// idlesound.play(stream);
		 
		 // exit
		// System.exit(0);
		
	}

}
