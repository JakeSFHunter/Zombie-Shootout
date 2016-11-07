import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GunPistol {
	short reloadTime = 60; //60 frames is 1 second ---- MAX: 127 frames; 2 seconds
	int bulletTravelDistance = 100;
	byte clipSize = 16;
	byte fireRate = 1; // 60 frames is 1 second
	byte Accuracy = 90; //out 100
	BufferedImage pistolImage;
	BufferedImage smallBullet;
	
	public short reloadTime() {
		return reloadTime;
	}
	
	public byte clipSize() {
		return clipSize;
	}
	
	public byte fireRate() {
		return fireRate;
	}
	
	public byte Accuracy() {
		return Accuracy;
	}
	
	public int bulletTravelDistance() {
		return bulletTravelDistance;
	}
	
	public BufferedImage graphics() {
		try {
			pistolImage = ImageIO.read(new File("Images/Gun/Pistol/Pistol.png"));
		} catch (IOException e) {
		}
		return pistolImage;
	}
	
	public BufferedImage Bullet() {
		try {
			smallBullet = ImageIO.read(new File("Images/Gun/SmallBullet.png"));
		} catch (IOException e) {
		}
		return smallBullet;
		
	}
}
