
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Pokemon {

	
	static Object[][] pokemonIndex = {
			{"bulbasaur", 5, 0, 20, 10, 12, 10, "bulbasaur.png", "bulbasaurBack.png"},
			{"charmander", 5, 0, 18, 12, 10, 12, "charmander.png", "charmanderBack.png"},
			{"squirtle", 5, 0, 20, 10, 14, 8, "squirtle.png", "squirtleBack.png"},
			{"pikachu", 5, 0, 18, 12, 10, 14, "pikachu.png", "pikachuBack.png"},
			{"pidgey", 5, 0, 20, 10, 10, 12, "pidgey.png", "pidgeyBack.png"}};
	
	
	
	String name;
    
    int x = 200;
    int y = 276;
    int hp;
    int hpMax;
    int lv = 5;
    int attack;
    int defense;
    int speed;
    int exp;

    //Image zimage;
    Image bigImage;
    Image image;
    
    Image pic;
    Image picHp;
    
    
    
    //fred code parts
    int xHp = 680;
    int yHp = 380;
    int xr = 890;
    int yr = 430;
    int wr = 240;
    int hr = 25;
    
    boolean isEnemy;
    boolean fullHealth = true;
    String chosenPokemon;
    
    
    

    private static final int LEVELTHRESHOLD = 500;
    ArrayList<Move> moves = new ArrayList<>();


    public Pokemon (String name, int hpMax, int lv, int attack, int defense, int speed) {
        this.name    = name;
        this.hpMax   = hpMax;
        this.lv      = lv;
        this.attack  = attack;
        this.defense = defense;
        this.speed   = speed;
       // this.x = x;
        //this.y = y;

        lv  = 5;
        exp = 0;
        hp  = 100;
        //this.hpMax = hpMax;
        //orignial
       // zimage    = Toolkit.getDefaultToolkit().getImage(name + ".png");
       // zimage = zimage.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    	
        //li pictures
        image    = Toolkit.getDefaultToolkit().getImage("../image/party_" + name + ".png");
		bigImage = Toolkit.getDefaultToolkit().getImage("../image/" + name + ".png");
        
		pic 	= Toolkit.getDefaultToolkit().getImage(name + "Back.png").getScaledInstance(256, 256, Image.SCALE_DEFAULT);
    	picHp 	= Toolkit.getDefaultToolkit().getImage("battleBarT.png").getScaledInstance(480, 120, Image.SCALE_DEFAULT);
		// bigImage = Toolkit.getDefaultToolkit().getImage("../image/" + name + ".png");
    }
    
    public Pokemon(String name, int lv) {
    	this.x = 715;
    	this.y = 80;
    	this.xHp = 30;
    	this.yHp = 50;
    	this.name = name;
    	xr = 215;
        yr = 115;
        wr = 240;
        hr = 25;
        
        pic 	= Toolkit.getDefaultToolkit().getImage(name + ".png").getScaledInstance(256, 256, Image.SCALE_DEFAULT);
    	picHp 	= Toolkit.getDefaultToolkit().getImage("battleBarE.png").getScaledInstance(480, 120, Image.SCALE_DEFAULT);
    	setPokemon(name, lv);
    	
    }
    
    private void setPokemon(String name, int lv) {
    	this.name    = name;
        this.hpMax   = 20;
        this.attack  = 10;
        this.defense = 12;
        this.speed   = 10;
        
        exp = 0;
        hp  = hpMax;
        
        setLv(lv);
	}
    
    private void setLv(int lv) {
		int newLv = lv - this.lv;
		
		for(int i = 0; i < newLv; i++){
			hpMax 	+= 2;
		    attack 	+= 2;
		    defense += 2;
		    speed 	+= 2;
		}
		
	}
    
    
    

    public void incHp (int amount) {
        hp = Math.min(hpMax, hp+amount);
    }

    public void decHp (int amount) {
        hp = Math.max(0, hp-amount);
    }

//    public void incExp (int amount) {
//        exp += amount;
//        while (exp >= LEVEL_THRESHOLD) {
//            exp -= LEVEL_THRESHOLD;
//            lv++;
//        }
//    }

//    public int expToNextLv() {
//        return LEVEL_THRESHOLD - exp;
//    }
    
    public int expToNextLv() {
		return LEVELTHRESHOLD - exp;
	}
    
    public void draw(Graphics g) {
    	
    	g.drawImage(pic, x, y, null);
    	g.drawImage(picHp, xHp, yHp, null);	
    	//g.drawRect(100, 100, 200, 200);
    	
    }
    
    public void drawhp(Graphics g){
    	if(fullHealth){
	    	g.setColor(Color.GREEN);
	    	g.fillRect(xr, yr, wr, hr);
	    	g.setColor(Color.BLACK);
    	}
    	
    	if(!fullHealth){
    		if(((double)hp / hpMax) < 1 && ((double)hp / hpMax) > 0.5 ){
    			g.setColor(Color.GREEN);
    			g.fillRect(xr, yr, wr, hr);
    			g.setColor(Color.BLACK);
    			g.fillRect(xr + wr, yr, 240 - wr, hr);
    		}else if(((double)hp / hpMax) <= 0.5 && ((double)hp / hpMax) > 0.25 ){
    			g.setColor(Color.YELLOW);
    			g.fillRect(xr, yr, wr, hr);
    			g.setColor(Color.BLACK);
    			g.fillRect(xr + wr, yr, 240 - wr, hr);
    		}else if(((double)hp / hpMax) <= 0.25 && ((double)hp / hpMax) > 0){
    			g.setColor(Color.RED);
    			g.fillRect(xr, yr, wr, hr);
    			g.setColor(Color.BLACK);
    			g.fillRect(xr + wr, yr, 240 - wr, hr);
    		}else{
    			g.setColor(Color.BLACK);
    			g.fillRect(xr, yr, wr, hr);
    			g.fillRect(xr + wr, yr, 240 - wr, hr);
    		}
    		
    	}
    
    }
    
    
    public boolean canstillbattle() {
    	return hp > 0;
    	
    }
    
    public int attack() {
    	return attack;
    	
    }
    
    public void learnMove(Move m) {
		moves.add(m);
	}
    public void healthbar(){
    	double health = (double)hp / hpMax;	
    	wr = (int)(wr * health);
    	
    	if(wr < 240) {
    		fullHealth = false;
    	}
    	
    }
    


}