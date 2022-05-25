package cityView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cityView.CityFrame;

public class CityFrameCloser extends WindowAdapter {
	
	protected CityFrame cityFrame;
	
	public CityFrameCloser(CityFrame cityFrame)
	{
		this.cityFrame = cityFrame;
	}

	
	@Override
	public void windowClosing(WindowEvent event) {
		this.cityFrame.setVisible(false);
		this.cityFrame.getWorldMap().setVisible(true);
		
	}

	

}
