import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	Main_Menu Main_Menu = new Main_Menu();
	ImageRotator ImageRotator = new ImageRotator();

	public int xPlayer = Game.xOffset,
			yPlayer = (Game.yOffset + Game.tileSize); // Player position
	public byte xPlayerS, yPlayerS; // Speed of Player
	boolean PlayerAlive = true;
	private byte Speed = 2;
	BufferedImage Player_Image;
	
	public Player() {
		try {
			Player_Image = ImageIO.read(new File("Images/Mob/Player/Player-Matt.png"));
		} catch (IOException e) {
		}
	}
	
	public void MovePlayer(boolean keyS, boolean keyW, boolean keyA,
			boolean keyD, boolean keySpace) {
		if (PlayerAlive == true) {

			if (keyS == true) {
				yPlayerS = Speed;
				xPlayerS = 0;
			}
			if (keyW == true) {
				yPlayerS = (byte) -Speed;
				xPlayerS = 0;
			}
			if (keyD == true) {
				xPlayerS = Speed;
				yPlayerS = 0;
			}
			if (keyA == true) {
				xPlayerS = (byte) -Speed;
				yPlayerS = 0;
			}

			
		}
		// ***********************
		
		// xPlayerBoundrys
		if (xPlayer < Game.xOffset) {
			xPlayer = Game.xOffset;
		}
		if (xPlayer > (Game.xScreen - 8)) {
			xPlayer = (Game.xScreen - 8);
		}

		// yPlayerBountrys
		if (yPlayer < Game.yOffset) {
			yPlayer = Game.yOffset;
		}
		if (yPlayer > Game.yScreen) {
			yPlayer = Game.yScreen;
		}
		
		xPlayer += xPlayerS;
		yPlayer += yPlayerS;
	}

	public boolean AlivePlayer() {
		return PlayerAlive;
	}
	
	public BufferedImage graphics() {
		return ImageRotator.graphics(Player_Image, xPlayerS, yPlayerS);
	}

}
