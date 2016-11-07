import java.awt.image.BufferedImage;


public class GunInterface {
	ImageRotator ImageRotator = new ImageRotator();
	Bullet Bullet = new Bullet();
	
	//Gun classes
	GunPistol GunPistol = new GunPistol();
	
	//Gun ammo
	int gunPistol = -2; // -2 is infinite
	
	//Gun pickup?
	boolean pickPistol = true;
	
	//Current Gun //Pistol = 0, Rifle = 1, Shotgun = 2
	byte currentGun = 0;
	BufferedImage ImageGun = null;
	int travelDistance = 0;
	byte fireRate = 0;
	
	public int TravelDistance() {
		if(currentGun == 0) {
			travelDistance = GunPistol.bulletTravelDistance;
		}
		return travelDistance;
	}
	
	public byte fireRate() {
		if(currentGun == 0) {
			fireRate = GunPistol.fireRate();
		}
		return fireRate;
	}
	
	
	public BufferedImage Gungraphics(byte xGunUser, byte yGunUser) {
		if(currentGun == 0) {
			ImageGun = GunPistol.graphics();
		}
		
		return ImageRotator.graphics(ImageGun, xGunUser, yGunUser);
	}
	
	public BufferedImage Bulletgraphics(byte xBullet, byte yBullet) {
		if(currentGun == 0) {
			ImageGun = GunPistol.Bullet();
		}
		
		return ImageRotator.graphics(ImageGun, xBullet, yBullet);
	}
	
	public void Gun(boolean Fire, byte xPlayerS, byte yPlayerS, int xPlayer, int yPlayer) {
		if(Fire == true) {
			for(int x = 0; x <= fireRate(); x++) {
				if(x == fireRate) {
					Bullet.createBullet(xPlayer, yPlayer, xPlayerS, yPlayerS);
				}
			}
		}
		Bullet.flyBullet(currentGun, TravelDistance());
	}
	
	public int xBullet() {
		return Bullet.xBullet;
	}
	
	public int yBullet() {
		return Bullet.yBullet;
	}

	public boolean BulletExist() {
		return Bullet.BulletExist();
	}
}
