package cityView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cityView.CityPanel;

public class MyMouseListener extends MouseAdapter{
	protected CityPanel cityPanel;
	
	public MyMouseListener(CityPanel cityPanel)
	{
		this.cityPanel = cityPanel;
	}


    @Override
    public void mouseClicked(MouseEvent event) {
         int  x = event.getX();
         int  y = event.getY();
         this.cityPanel.handleClick(x, y);

    }
}
