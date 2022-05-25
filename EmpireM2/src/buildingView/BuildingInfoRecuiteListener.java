

//public class BuildingInfoRecuiteListener {


package buildingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import units.Unit;
import buildings.MilitaryBuilding;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;

public class BuildingInfoRecuiteListener implements ActionListener  {
	BuildingInfoFrame frame;

		public BuildingInfoRecuiteListener(BuildingInfoFrame frame){
			this.frame = frame;
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton buttonClicked=(JButton)event.getSource();
			String buttonTxt = buttonClicked.getText();
			
			double gold = this.frame.getCityFrame().getWorldMap().getGame().getPlayer().getTreasury();
			MilitaryBuilding building = (MilitaryBuilding)  frame.getCurrentBuilding();
			int multiplier = 1;
			switch(buttonTxt)
			{
				case "1 Unit": multiplier = 1; break;
				case "2 Units": multiplier = 2; break;
				case "3 Units": multiplier = 3; break;
			
			}
			if(building.getRecruitmentCost()*multiplier>gold)
			{
				JOptionPane.showMessageDialog(null, "Not enough gold ","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Unit unit = null;
			City city = this.frame.cityFrame.getCity();
			
			Game game = this.frame.cityFrame.getWorldMap().getGame();
			Player player = this.frame.cityFrame.getWorldMap().getGame().getPlayer();
			
			try {
				for(int i=1; i<=multiplier; i++)
				{
					unit = building.recruit();
					unit.setParentArmy(city.getDefendingArmy());
					city.getDefendingArmy().getUnits().add(unit);
				}
				this.frame.getCityFrame().getWorldMap().getGame().getPlayer().setTreasury(gold-building.getRecruitmentCost()*multiplier);
			} catch (BuildingInCoolDownException e) {
				JOptionPane.showMessageDialog(null, "Please wait for cool down ","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (MaxRecruitedException e) {
				JOptionPane.showMessageDialog(null, "Max Recruit per turn reached","ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.frame.cityFrame.updateDisplay();

			this.frame.setVisible(false);
			
			
			this.frame.cityFrame.setTitle("player: " + player.getName() +
					"  City: " + city.getName() + "  Gold: " + player.getTreasury() +
					"  Food: " + player.getFood() + "  Turn:" + game.getCurrentTurnCount());
			
				
			
	}


}



