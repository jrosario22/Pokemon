import java.awt.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.awt.GraphicsEnvironment;

public class Bag implements KeyListener
{		
	// Instance Variables
	Potion normPotion;
	Potion superPotion;
	//Pokeball pokeball;
	//Pokeball greatball;
	Font pokemonFont;
	
	int normPotionCount  = 5;
 	int superPotionCount = 5;
 	int pokeballCount = 5;
 	int greatballCount = 5;
	int redXBox = 563;
	int redYBox = 82;
	private int selectedVerticalIndex = 0;
	private int selectedHorizontalIndex = 0;
	//
 	
 	// Arrays
 	String [] potionNames = {"NORMAL POTION","SUPER POTION"};
 	String [] potionCount = {"X" + normPotionCount, "X" + superPotionCount};
 	
 	String [] pokeballNames = {"POKEBALL","GREAT BALL"};
 	String [] ballCount = {"X" + pokeballCount, "X" + greatballCount};
 	//
 	
	// Gets bag image
	Image bag 			 = Toolkit.getDefaultToolkit().getImage("Bag.png");
	Image bagBackArrow 	 = Toolkit.getDefaultToolkit().getImage("Bag.Back.Arrow.png");
	Image bagRedBox 	 = Toolkit.getDefaultToolkit().getImage("Bag.Red.Box.png");
	Image bagLeftArrow 	 = Toolkit.getDefaultToolkit().getImage("Bag.Left.Arrow.png");
	Image bagRightArrow  = Toolkit.getDefaultToolkit().getImage("Bag.Right.Arrow.png");
	//
	
	// Gets Items Images
	Image bagPotionPouch = Toolkit.getDefaultToolkit().getImage("Bag.Potion.Pouch.png");
	Image bagItemsTitle  = Toolkit.getDefaultToolkit().getImage("Bag.Items.Title.png");
	//
	
	// Gets Pokeballs Images
	Image bagPokeballsPouch = Toolkit.getDefaultToolkit().getImage("Bag.Pokeballs.Pouch.png");
	Image bagPokeballsTitle  = Toolkit.getDefaultToolkit().getImage("Bag.Pokeballs.Title.png");
	//	
	@Override
	public void keyTyped(KeyEvent e) 
	{
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
	
	}	
	
	// Constructor
	public Bag() 
	{
		// Creates value for Potion
		normPotion  = new Potion (10);
		superPotion = new Potion(20);
		//
		
		// Resize Image
		bag 				= bag.getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
		bagPotionPouch 		= bagPotionPouch.getScaledInstance(335, 335, Image.SCALE_DEFAULT);
		bagBackArrow 		= bagBackArrow.getScaledInstance(152, 131, Image.SCALE_DEFAULT);
		bagItemsTitle 		= bagItemsTitle.getScaledInstance(400, 65, Image.SCALE_DEFAULT);
		bagRedBox 			= bagRedBox.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
		bagLeftArrow 		= bagLeftArrow.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		bagRightArrow 		= bagRightArrow.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		
		bagPokeballsPouch  	= bagPokeballsPouch.getScaledInstance(335, 335, Image.SCALE_DEFAULT);
		bagPokeballsTitle 	= bagPokeballsTitle.getScaledInstance(400, 70, Image.SCALE_DEFAULT);
		//
		
		try 
		{
			// Font is created and searched for
			pokemonFont = Font.createFont(Font.TRUETYPE_FONT, new File("pokemon_fire_red.ttf")).deriveFont(48f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("pokemon_fire_red.ttf")));
			
		}
		catch(IOException | FontFormatException e) {}
		

	}
	//
	
	public int getIndex() 
	{
		return selectedVerticalIndex;
	}
	
	public void moveUp() 
	{
		if(selectedVerticalIndex > 0 ) 
		{
			selectedVerticalIndex--;
			redYBox -= 50;
			System.out.println("Moved Up");	
		}
	}
	
	public void moveDown() 
	{
		if(selectedVerticalIndex < potionNames.length - 1) 
		{
			selectedVerticalIndex++;
			redYBox += 50;
			System.out.println("Moved Down");
		}
	}
	
	public void moveLeft() 
	{
		if(selectedHorizontalIndex > 0) 
		{
			selectedHorizontalIndex--;
			//redYBox -= 50;
			System.out.println("Moved Left");	
		}
	}
	
	public void moveRight() 
	{
		if(selectedHorizontalIndex < potionNames.length - 1) 
		{
			selectedHorizontalIndex++;
			//redYBox += 50;
			System.out.println("Moved Left");
		}
	}
	
	// Potion Use
	public void useNormPotion()
    {
        if(normPotionCount > 0)
        {
            normPotionCount--;
            normPotion.usePotion();
        }
    }
	
	public void useSuperPotion()
    {								
		if(superPotionCount > 0) 
		{
			superPotionCount--; 
	        superPotion.usePotion();
	    }
    }
	//
	
	/*// Pokeball Use
	public void usePokeball()
    {
        if(pokeballCount > 0)
        {
            pokeballCount--;
            pokeball.katch();
        }
    }
	//*/
	
	// Bag Graphic
	public void drawItems(Graphics g)
	{
		// Draw Bag
		g.drawImage(bag, 0, 0, null);
		g.drawImage(bagBackArrow, 21, 360, null);
		g.drawImage(bagRightArrow, 505, 55, null);
		//
		
		// Draw Items Pouch
		if (selectedHorizontalIndex < potionNames.length - 1)
		{
			g.drawImage(bagPotionPouch, 185, 165, null);
			g.drawImage(bagItemsTitle, 118, 48, null);
			g.drawImage(bagLeftArrow, 105, 55, null); // Placed in here to not cover Title
			g.drawImage(bagRedBox, 211, 138, null);
			
			for(int i = 0; i < potionNames.length; i++) 
			{
				g.setColor(Color.BLACK);
				g.setFont(pokemonFont);
				g.drawString(potionNames[i], 566, 115 + (i * 50 ));
			}
			
			for(int i = 0; i < potionCount.length; i++) 
			{
				g.setColor(Color.BLACK);
				g.setFont(pokemonFont);
				g.drawString(potionCount[i], 1121, 115 + (i * 50 ));
			}
		}
		//
		
		// Draw Pokeballs Pouch
		if(selectedHorizontalIndex > 0)
		{
			g.drawImage(bagPokeballsPouch, 185, 165, null);
			g.drawImage(bagPokeballsTitle, 118, 48, null);
			g.drawImage(bagLeftArrow, 105, 55, null); // Placed in here to not cover Title
			g.drawImage(bagRedBox, 250, 138, null);
			
			for(int i = 0; i < pokeballNames.length; i++) 
			{
				g.setColor(Color.BLACK);
				g.setFont(pokemonFont);
				g.drawString(pokeballNames[i], 566, 115 + (i * 50 ));
			}
			
			for(int i = 0; i < ballCount.length; i++) 
			{
				g.setColor(Color.BLACK);
				g.setFont(pokemonFont);
				g.drawString(ballCount[i], 1121, 115 + (i * 50 ));
			}
		}
		//
	
		
		// Draws Selector(Red Box)
		g.setColor(Color.red);
		((Graphics2D) g).setStroke(new BasicStroke(3)); // Casting denigrates the graphics in order to thicken box
		g.drawRect(redXBox, redYBox, 610, 47);
		
	}


	
	
}
