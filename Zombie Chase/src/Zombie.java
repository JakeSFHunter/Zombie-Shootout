import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class Zombie {
	SmartAI SmartAI = new SmartAI();
	ImageRotator ImageRotator = new ImageRotator();

	public int xZombie = Game.xScreen / 2;
	public int yZombie = Game.yScreen / 2;
	public int zombieKilled = 0;

	//private int xRanZombie = 0;
	//private int yRanZombie = 0;

	Random randomint = new Random();
	BufferedImage Zombie_Image;
	

	public Zombie() {
		xZombie = Game.xScreen;
		yZombie = Game.yScreen;
		
		try {
			Zombie_Image = ImageIO.read(new File("Images/Mob/Reg-Zombie/Zombie.png"));
		} catch (IOException e) {
		}
	}

	public void MoveZombie(int xPlayer, int yPlayer) {
		//TODO Random spawning locations
		//xRanZombie = randomint.nextInt(2);
		//yRanZombie = randomint.nextInt(10);

		SmartAI.start(xZombie, yZombie, xPlayer, yPlayer);
		xZombie = SmartAI.xZombie();
		yZombie = SmartAI.yZombie();
	}

	public BufferedImage graphics() {
		return ImageRotator.graphics(Zombie_Image, SmartAI.xImage(), SmartAI.yImage());
	}
}