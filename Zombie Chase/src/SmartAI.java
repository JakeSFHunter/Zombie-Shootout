
public class SmartAI {
	//Variable calls
	private int xDistance;
	private int yDistance;
	private int xAbsDist;
	private int yAbsDist;
	private int xAttackerT;
	private int yAttackerT;
	private byte xDirection;
	private byte yDirection;
	
	public void start(int xAttacker, int yAttacker, int xTarget, int yTarget) {
		//Variable calls
				xDistance = xTarget - xAttacker; //Distance in X and Y direction from Attacker and Target
				yDistance = yTarget - yAttacker;
				xAbsDist = Math.abs(xDistance); //Distance in X and Y direction from Attacker and Target (No negatives)
				yAbsDist = Math.abs(yDistance);
				
				if(xAbsDist > 0)
				xDirection = (byte) (xDistance / xAbsDist); // +1 or -1 direction (+1 is away from zero)
				else
					xDirection = 0;
					
				if(yAbsDist > 0)
				yDirection = (byte) (yDistance / yAbsDist);
				else
					yDirection = 0;
				
				xAttackerT = xAttacker;
				yAttackerT = yAttacker;
	}
	
	public int xDirection() {
		return xDirection;
	}
	public int yDirection() {
		return yDirection;
	}
	
	public int xZombie() {
		return xAttackerT + xDirection;
	}
	public int yZombie() {
		return yAttackerT + yDirection;
	}	

	public byte xImage() {
		byte Image = 0;
		if(xAbsDist > yAbsDist) {
			Image = xDirection;
		}
		return Image;
	}
	
	public byte yImage() {
		byte Image = 0;
		if(yAbsDist > xAbsDist) {
			Image = yDirection;
		}
		return Image;
	}
}