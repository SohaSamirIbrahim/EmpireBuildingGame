package worldMapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import engine.City;
import engine.Game;

public class WorldMapListener implements ActionListener {
	private WorldMapFrame map;


	public WorldMapListener(WorldMapFrame map){
		this.map = map;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Game game = map.getGame();

		JButton buttonClicked=(JButton)e.getSource();
		String cityNameClicked= buttonClicked.getText();
		boolean found = false;
		
		for(City city : game.getPlayer().getControlledCities())
		{
			if(city.getName().equals(cityNameClicked))
			{
				this.map.setVisible(false);
				this.map.showCity(city);
				found = true;
				break;
			}
		}
		
		
		if(!found)
		{
			JOptionPane.showMessageDialog(null, "You are not controlling this city", "Error", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
