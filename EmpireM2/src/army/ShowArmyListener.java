package army;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cityView.CityFrame;
import units.Army;
import units.Unit;
import engine.City;
import engine.Game;

public class ShowArmyListener implements ActionListener {
	String text;
	CityFrame cityFrame;
	ShowArmyFrame showArmyFrame;
	
	public ShowArmyListener(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
		this.showArmyFrame = this.cityFrame.getShowArmyframe();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game game = this.cityFrame.getWorldMap().getGame();
		City city = this.cityFrame.getCity();
		int index = this.cityFrame.getArmySelector().getSelectedIndex();
		if(index == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select an army");
			return;
		}
			this.showArmyFrame = new ShowArmyFrame(this.cityFrame);
			text = "..";
			Army army = (Army) this.cityFrame.getArmySelector().getItemAt(index);
			for (Unit armyUnit : army.getUnits())
			{	
				text = "<html><strong>Units :  </strong> <br>" + armyUnit.toString() + "<br>" + text + " </html>";
			}
			this.showArmyFrame.getLabel().setText(text);
			this.showArmyFrame.setVisible(true);

	}


}
