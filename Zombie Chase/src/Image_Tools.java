import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;


public class Image_Tools {
	
	public static BufferedImage rotate(BufferedImage image, double angle) {
		BufferedImage result = null;
		if(image == null) {
			result = image;
		} else {
			double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		    int w = image.getWidth(), h = image.getHeight();
		    int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
		    GraphicsConfiguration gc = getDefaultConfiguration();
		    result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		    Graphics2D g = result.createGraphics();
		    g.translate((neww-w)/2, (newh-h)/2);
		    g.rotate(angle, w/2, h/2);
		    g.drawRenderedImage(image, null);
		    g.dispose();
		}
	    return result;
	}

	public static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
}
