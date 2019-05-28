public class Move {
	
	MoveType moveType;
	int ppRemain;
	int power;

	
	public Move (MoveType moveType) {
		this.moveType = moveType;
		ppRemain = moveType.pp;
		this.power = moveType.power;
	}
	
	public void decPP() {
		if (ppRemain > 0) ppRemain--;
	}

}