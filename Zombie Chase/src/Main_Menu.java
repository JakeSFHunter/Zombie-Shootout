public class Main_Menu {
	public boolean started = false;
	short position = 2, maxPosition = 2;
	boolean showSettings = false, showDebug = false;

	public Main_Menu() {
	}

	public void Menu(boolean keySpace) {
		if (started == false) {

			if ((position == 0) && (keySpace == true)) {
				keySpace = false;
				started = true;
			}
			if ((position == 1) && (keySpace == true)) {
				keySpace = false;
				showSettings = true;
			}

			if (showSettings == true) {

				if ((position == 2) && (keySpace == true)) {
					showDebug = true;
					keySpace = false;
				}
				if ((position == 3) && (keySpace == true)) {
					showSettings = false;
					position = 1;
					keySpace = false;
				}
			}

			if ((position == maxPosition) && (keySpace == true)) {
				System.exit(0);
			}
		}
	}

	public void menuMovement(boolean keyW, boolean keyS) {
		if (keyS == true) {
			position++;
			keyS = false;
		}
		if (keyW == true) {
			position--;
			keyW = false;
		}
		if (position < 0) {
			position = 0;
		}
		if (position > maxPosition) {
			position = maxPosition;
		}
	}
}