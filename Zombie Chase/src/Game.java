import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;

public class Game extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	public static int tileSize = 16;
	public static int xOffset = tileSize / 2, yOffset = tileSize;
	public static int xScreen = 640, yScreen = 480; // window size
	int xBoundry = xScreen, yBoundry = (yScreen - tileSize); // Field boundrys
	boolean gameReset = false;

	// Keyboard
	BufferedImage Zombie_Left = null;

	Random randomint = new Random();
	// Delay
	long firstCheck = 0;
	long secondCheck = 0;
	int finalCheck = 0;

	// Fonts
	Font myFont = new Font("Serif", Font.BOLD, 20);
	Font myFont2 = new Font("Cambria Math", Font.BOLD, 20);

	// Class call
	Keyboard Keyboard = new Keyboard();
	Main_Menu Main_Menu = new Main_Menu();
	Zombie Zombie = new Zombie();
	Player Player = new Player();
	GunInterface GunInterface = new GunInterface();

	public Game() {
		Timer tm = new Timer((1000 / 60), this);
		tm.start();
		addKeyListener(Keyboard);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g) {
		firstCheck = System.currentTimeMillis();
		// **********************************
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(xOffset, yOffset, xScreen, yScreen);
		g.setColor(Color.BLACK);
		g.drawRect(xOffset, yOffset, xScreen, yScreen);

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, xOffset, yScreen + (4 * tileSize));
		g.fillRect(0, 0, xScreen + (2 * tileSize), yOffset);

		g.fillRect(xScreen + tileSize / 2 + 1, 0, tileSize * 2, yScreen
				+ tileSize * 3);
		g.fillRect(0, yScreen + tileSize + 1, xScreen + (2 * tileSize), yOffset
				+ tileSize);

		if (Main_Menu.showDebug == true) {
			g.setColor(Color.BLACK);
			g.drawString("Latency Test: " + Integer.toString(finalCheck),
					xOffset + tileSize * 0 + 8, yScreen - tileSize - 4);

			// g.drawString("Total Zombies: " +
			// Integer.toString(Zombie.totalZombies), xOffset + tileSize * 0 +
			// 8, yScreen - tileSize / 2);
			// g.drawString("Wave: " + Integer.toString(Zombie.spawnZombies +
			// 1), xOffset + tileSize * 8 + 8, yScreen - tileSize / 2);

			g.drawString("Player's X: " + Integer.toString(Player.xPlayer),
					xOffset + tileSize * 0 + 8, yScreen + 4);
			g.drawString("Player's Y: " + Integer.toString(Player.yPlayer),
					xOffset + tileSize * 6 + 8, yScreen + 4);
			// g.drawString("Beam Time: " + Player.fireOne, xOffset + tileSize *
			// 12 + 8, yScreen);
			// g.drawString("Gun Firing: " + Player.Player1GunOn, xOffset +
			// tileSize * 18 + 8, yScreen);

			g.drawString("Space Pressed: " + Keyboard.keySpace, xOffset
					+ tileSize * 0 + 8, yScreen + tileSize / 2 + 8);
			g.drawString("D Pressed: " + Keyboard.keyD, xOffset + tileSize * 8
					+ 8, yScreen + tileSize / 2 + 8);
			g.drawString("Menu Position: " + Main_Menu.position, xOffset
					+ tileSize * 16 + 8, yScreen + tileSize / 2 + 8);

		}

		if (Main_Menu.started == false) {
			g.setColor(Color.BLUE);
			g.setFont(myFont2);
			g.drawString("Start", (xScreen / 2), 200 + (25 * 0));
			g.drawString("Settings", (xScreen / 2), 200 + (25 * 1));
			g.drawString("Exit", (xScreen / 2),
					200 + (25 * Main_Menu.maxPosition));

			g.setColor(Color.BLACK);
			g.drawRect(100, 100, (tileSize * 2), (tileSize * 2));
			g.drawRect(100 - (tileSize * 2), 100 + (tileSize * 2),
					(tileSize * 6), (tileSize * 2));
			g.drawRect(100, 100 + (tileSize * 2), (tileSize * 2),
					(tileSize * 2));
			g.drawRect(110, 196, (tileSize * 8), (tileSize * 2));

			g.setColor(Color.BLUE);
			g.setFont(myFont);
			g.drawString("W", 108, 124);
			g.drawString("S", 110, 156);
			g.drawString("A", 78, 156);
			g.drawString("D", 142, 156);
			g.drawString("Space", 142, 220);

			// ***************************************************************************************

			if (Main_Menu.showSettings == true) {
				Main_Menu.maxPosition = 4;
				g.drawString("  Debugger: " + Main_Menu.showDebug,
						(xScreen / 2), 200 + (25 * 2));
				g.drawString("  Exit Settings", (xScreen / 2), 200 + (25 * 3));
			} else {
				Main_Menu.maxPosition = 2;
			}

			if (Main_Menu.showDebug == true) {
				if ((Main_Menu.position == 2) && (Keyboard.keySpace == true)) {
					Main_Menu.showDebug = false;
					Keyboard.keySpace = false;
				}
			}

			g.setColor(Color.RED);
			g.fillRect(xScreen / 2 - 16, 190 + (25 * Main_Menu.position),
					tileSize / 2, tileSize / 2);
		} else {
			if (Player.AlivePlayer() == true) {
				g.setColor(Color.BLACK);
				g.drawImage(Player.graphics(), Player.xPlayer, Player.yPlayer, this);
			}
			
			if(GunInterface.BulletExist()) {
				g.drawImage(GunInterface.Bulletgraphics(Player.xPlayerS, Player.yPlayerS), GunInterface.xBullet(), GunInterface.yBullet(), this);
			}
			g.drawImage(GunInterface.Gungraphics(Player.xPlayerS, Player.yPlayerS), Player.xPlayer, Player.yPlayer, this);
			
			g.drawImage(Zombie.graphics(), Zombie.xZombie, Zombie.yZombie, this);
			

			if (gameReset == true) {
				Player.xPlayer = xOffset;
				Player.yPlayer = (yOffset + tileSize);
				Player.xPlayerS = 0;
				Player.yPlayerS = 0;
				Zombie.zombieKilled = 0;
				Player.PlayerAlive = true;

				Main_Menu.started = false;
				gameReset = false;
			}

		}

		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (Main_Menu.started == false) {
			Main_Menu.menuMovement(Keyboard.keyW, Keyboard.keyS);
			Main_Menu.Menu(Keyboard.keySpace);
		} else {
			Zombie.MoveZombie(Player.xPlayer, Player.yPlayer);
			
			Player.MovePlayer(Keyboard.keyS, Keyboard.keyW, Keyboard.keyA,
					Keyboard.keyD, Keyboard.keySpace);
			GunInterface.Gun(Keyboard.keySpace, Player.xPlayerS, Player.yPlayerS, Player.xPlayer, Player.yPlayer);
		}

		if (Keyboard.keyP) {
			gameReset = true;
		}
		// ***********************

		secondCheck = System.currentTimeMillis();
		finalCheck = (int) (secondCheck - firstCheck);
	}

	public static void main(String[] args) {
		JFrame frm = new JFrame("Zombie Chase");
		frm.getContentPane().add(new Game());
		frm.setSize((xScreen + (2 * tileSize)), (yScreen + (4 * tileSize)));
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
