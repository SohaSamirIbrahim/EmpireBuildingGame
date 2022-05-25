package army;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cityView.CityFrame;
import units.Army;

public class DisplayNewArmyListener implements ActionListener {

	protected CityFrame cityFrame;

	
	public DisplayNewArmyListener(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.cityFrame.getNewArmyFrame().display(cityFrame.getCity());
		this.cityFrame.getNewArmyFrame().setVisible(true);
	}


}
