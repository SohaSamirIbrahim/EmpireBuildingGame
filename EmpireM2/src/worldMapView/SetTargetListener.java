package worldMapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import units.Army;
import units.Status;
import engine.City;
import engine.Game;

public class SetTargetListener implements ActionListener {
	
	ControlledArmiesFrame frame;
	WorldMapFrame map;

	public SetTargetListener(ControlledArmiesFrame frame){
		this.frame = frame;
		this.map = frame.map;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game game = this.frame.map.getGame();
		int armyIndex = this.frame.map.getArmySelector().getSelectedIndex();
		int cityIndex = this.frame.targetSelector.getSelectedIndex();
		if(cityIndex == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Target City");
			return;
		}
		Army army = (Army) this.frame.map.getArmySelector().getItemAt(armyIndex);
		String cityName = (String) this.frame.targetSelector.getItemAt(cityIndex);
		for(City c : game.getPlayer().getControlledCities()){
			if(c.getName().equals(cityName))
			{
				JOptionPane.showMessageDialog(null, "You are controlling this city", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}	
		}
		
		if(!army.getCurrentStatus().equals(Status.IDLE)){
			JOptionPane.showMessageDialog(null, "Army is not Idle", "Error", JOptionPane.ERROR_MESSAGE);
		}
		game.targetCity(army, cityName);
		frame.revalidate();
		frame.repaint();
		map.controlledArmiesFrame.revalidate();
		map.controlledArmiesFrame.repaint();
		
	
		
	}

}
