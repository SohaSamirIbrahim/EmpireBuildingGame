package cityView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import battleView.AttackListener;
import engine.City;
import engine.Game;

public class NextTurnListener implements ActionListener {

	protected CityFrame cityFrame;
	AttackListener attack;
	
	public NextTurnListener(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Game game = this.cityFrame.getWorldMap().getGame();
		
		ArrayList<City> underSiegeCities = new ArrayList<City>();
		for(City c : game.getAvailableCities()){
			if(c.isUnderSiege())
				underSiegeCities.add(c);
		}
		
		game.endTurn();
		this.cityFrame.setVisible(false);
		
		for(City city: underSiegeCities){
			if(!city.isUnderSiege())
				attack = new AttackListener(cityFrame.worldMap);
		}
		
		
		if(cityFrame.worldMap.game.isGameOver()){
			String text = "GAME OVER";
			if(cityFrame.worldMap.game.getPlayer().getControlledCities().size()==3)
				text = text + "\n" + "YOU WON!";
			else
				text = text + "\n" + "YOU LOST";
			JOptionPane.showMessageDialog(null, text, "Game Over", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		
		
		if(cityFrame.worldMap.canBesiegeOrAttack("Sparta")){
			cityFrame.worldMap.attackSparta.setVisible(true);
			cityFrame.worldMap.besiegeSparta.setVisible(true);
		}
		if(cityFrame.worldMap.canBesiegeOrAttack("Cairo")){
			cityFrame.worldMap.attackCairo.setVisible(true);
			cityFrame.worldMap.besiegeCairo.setVisible(true);
		}
		if(cityFrame.worldMap.canBesiegeOrAttack("Rome")){
			cityFrame.worldMap.attackRome.setVisible(true);
			cityFrame.worldMap.besiegeRome.setVisible(true);
		}
		
		
		cityFrame.worldMap.revalidate();
		cityFrame.worldMap.repaint();
		this.cityFrame.worldMap.setVisible(true);

	}

}
