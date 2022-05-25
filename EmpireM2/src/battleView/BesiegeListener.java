package battleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import units.Army;
import worldMapView.WorldMapFrame;
import engine.City;
import exceptions.FriendlyCityException;
import exceptions.TargetNotReachedException;

public class BesiegeListener implements ActionListener{
	WorldMapFrame frame;
	Army playerArmy;
	City beseigedCity;
	public BesiegeListener(WorldMapFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked=(JButton)e.getSource();
		String cityNameClicked= buttonClicked.getActionCommand();
		if(cityNameClicked.equals("besiegeCairo")){
			this.beseigedCity= this.findCity("Cairo");
			this.playerArmy=this.findArmy("Cairo");
			try {
				frame.game.getPlayer().laySiege(this.playerArmy, this.beseigedCity);
			} catch (TargetNotReachedException e1) {
				JOptionPane.showMessageDialog(null, "Target not reached yet", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (FriendlyCityException e1) {
				JOptionPane.showMessageDialog(null, "Beseiging a friendly city", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(cityNameClicked.equals("besiegeRome")){
			this.beseigedCity= this.findCity("Rome");
			this.playerArmy=this.findArmy("Rome");
			try {
				frame.game.getPlayer().laySiege(this.playerArmy, this.beseigedCity);
			} catch (TargetNotReachedException e1) {
				JOptionPane.showMessageDialog(null, "Target not reached yet", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (FriendlyCityException e1) {
				JOptionPane.showMessageDialog(null, "Beseiging a friendly city", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(cityNameClicked.equals("besiegeSparta")){
			this.beseigedCity= this.findCity("Sparta");
			this.playerArmy=this.findArmy("Sparta");
			try {
				frame.game.getPlayer().laySiege(this.playerArmy, this.beseigedCity);
			} catch (TargetNotReachedException e1) {
				JOptionPane.showMessageDialog(null, "Target not reached yet", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (FriendlyCityException e1) {
				JOptionPane.showMessageDialog(null, "Beseiging a friendly city", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		this.frame.displayInfo();
		this.frame.revalidate();
		this.frame.repaint();
		
	}
	
	public City findCity(String name){
		City c = null;
		for(City current : frame.game.getAvailableCities()){
			if(current.getName().equals(name)){
				c= current;
				break;
			}
		}
		return c;
	}
	
	public Army findArmy(String target){
		Army a = null;
		for(Army current : frame.game.getPlayer().getControlledArmies()){
			if(current.getCurrentLocation().equals(target)){
				a= current;
				break;
			}
		}
		return a;
	}

}
