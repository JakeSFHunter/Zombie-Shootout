import java.awt.image.BufferedImage;

public class ImageRotator {
	public BufferedImage graphics(BufferedImage Image, byte xImage, byte yImage) {
		BufferedImage ImageD = Image;
		BufferedImage ImageL = Image_Tools.rotate(ImageD, Math.PI/2); //Left
		BufferedImage ImageU = Image_Tools.rotate(ImageD, Math.PI); //Up
		BufferedImage ImageR = Image_Tools.rotate(ImageD, -Math.PI/2); //Right
		
		
		if (yImage > 0) { //Down
			Image = ImageD;
		}
		
		if (yImage < 0) { //Up
			Image = ImageU;
		}
		
		if (xImage > 0) { //Right
			Image = ImageR;
		}
		
		if (xImage < 0) { //Left
			Image = ImageL;
		}
		return Image;
	}
}