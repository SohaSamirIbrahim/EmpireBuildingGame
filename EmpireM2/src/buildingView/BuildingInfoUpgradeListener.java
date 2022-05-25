package buildingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import buildings.Building;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class BuildingInfoUpgradeListener implements ActionListener  {
	BuildingInfoFrame frame;

		public BuildingInfoUpgradeListener(BuildingInfoFrame frame){
			this.frame = frame;
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton buttonClicked=(JButton)event.getSource();
			double gold = this.frame.getCityFrame().getWorldMap().getGame().getPlayer().getTreasury();
			Building building =  frame.getCurrentBuilding();
			if(building == null) {
				this.frame.cityFrame.repaint();
				this.frame.setVisible(false);
				return;
			}
			if(building.getUpgradeCost() > gold)
			{
				JOptionPane.showMessageDialog(null, "Not enough gold "
						,"ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try {
				double uCost = building.getUpgradeCost();
				building.upgrade();
				this.frame.getCityFrame().getWorldMap().getGame().getPlayer().setTreasury(gold-uCost);
				
			} catch (BuildingInCoolDownException e) {
				JOptionPane.showMessageDialog(null, "Please wait for cool down ",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} catch (MaxLevelException e) {
				e.printStackTrace();
				}
			Game game = this.frame.cityFrame.getWorldMap().getGame();
			Player player = this.frame.cityFrame.getWorldMap().getGame().getPlayer();
			City city = this.frame.cityFrame.getCity();
			this.frame.cityFrame.setTitle("player: " + player.getName() + "  City: "
					+ city.getName() + "  Gold: " + player.getTreasury() + "  Food: " + player.getFood() +
					"  Turn:" + game.getCurrentTurnCount());
			this.frame.cityFrame.repaint();
			this.frame.setVisible(false);
			
		
	}


}
