package worldMapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import units.Army;
import units.Status;
import units.Unit;
import engine.Game;

public class ControlledArmiesListener implements ActionListener {
	WorldMapFrame worldMap;
	ControlledArmiesFrame controlledArmies;
	JLabel info;
	public ControlledArmiesListener(WorldMapFrame worldMap){
		this.worldMap= worldMap;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game game = this.worldMap.getGame();
		int index = this.worldMap.getArmySelector().getSelectedIndex();
		if(index == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Unit");
			return;
		}
		Army army = (Army) this.worldMap.getArmySelector().getItemAt(index);
		controlledArmies = new ControlledArmiesFrame(this.worldMap);
		controlledArmies.armyLabel.setText(army.toString());
		if(army.getCurrentStatus().equals(Status.IDLE)){
			controlledArmies.target.setVisible(true);
			controlledArmies.targetSelector.setVisible(true);
		}
		String text = "";
		int i =1;
		for(Unit units : army.getUnits()){
			text = "<html><strong>Unit:" + i + "</strong> <br>" + units.toString() + "<br>" + text + " </html>";
			i++;			
		}
		controlledArmies.unitLabel.setText(text);
		controlledArmies.setVisible(true);
		
	}
	
}
