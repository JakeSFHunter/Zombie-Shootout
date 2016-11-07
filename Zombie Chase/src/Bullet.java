public class Bullet {
	int xBullet, yBullet;
	boolean BulletExist = false;
	byte xPlayerD, yPlayerD;
	int xTemp, yTemp;
	boolean checkRun = false;

	public void createBullet(int xPlayer, int yPlayer, byte xPlayerS,
			byte yPlayerS) {
		xBullet = xPlayer;
		yBullet = yPlayer;
		xPlayerD = xPlayerS;
		yPlayerD = yPlayerS;
		xTemp = xBullet;
		yTemp = yBullet;
		BulletExist = true;
	}

	public void flyBullet(byte currentGun, int travelDistance) {
		if (BulletExist = true) {
			if (xPlayerD != 0) {
				if (xPlayerD > 0) {
					if ((xTemp + travelDistance) >= xBullet) {
						xBullet += 4;
					} else {

					}
				}
				if (xPlayerD < 0) {
					if ((xTemp - travelDistance) <= xBullet) {
						xBullet -= 4;
					}
				}
			} else if (yPlayerD != 0) {
				if (yPlayerD < 0) {
					if ((yTemp - travelDistance) <= yBullet) {
						yBullet -= 4;
					}
				}
				if (yPlayerD > 0) {
					if ((yTemp + travelDistance) >= yBullet) {
						yBullet += 4;
					}
				}
			} else {
				BulletExist = false;
			}
		}
	}

	public boolean BulletExist() {
		return BulletExist;
	}

	public int xBullet() {
		return xBullet;
	}

	public int yBullet() {
		return yBullet;
	}
}
