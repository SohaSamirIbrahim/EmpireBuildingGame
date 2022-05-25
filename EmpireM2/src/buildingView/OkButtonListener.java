package buildingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import buildingView.BuildingInfoFrame;

public class OkButtonListener implements ActionListener {
	BuildingInfoFrame frame;

	public OkButtonListener(BuildingInfoFrame frame){
		this.frame = frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.frame.setVisible(false);
	}

}
