package worldMapView;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {

	  private Image backgroundImage;
	  public JPanelWithBackground(String name) throws IOException {
	    backgroundImage = ImageIO.read(new File(name));
	   
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(backgroundImage, 0, 0,850,500, this);
	  }
	}
