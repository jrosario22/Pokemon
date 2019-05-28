
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BattleStage{

	Image pic;
	Image resize;
	static String[] stages = {"Nor", "For", "Sea", "Cav", "Wet"};
	
	public BattleStage(int stageNum){		
		pic = Toolkit.getDefaultToolkit().getImage(chooseStage(stageNum));
		resize = pic.getScaledInstance(1200, 500, Image.SCALE_DEFAULT);
	}

	protected static String chooseStage(int stageNum){
		String chosenStage = "Stage" + stages[stageNum] + ".png";
		return chosenStage;
	}
	
	public void draw(Graphics g){
		g.drawImage(resize, 0, 0, null);
	}
	
}