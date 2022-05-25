package battleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import units.Army;
import units.Unit;
import worldMapView.WorldMapFrame;
import engine.City;
import engine.Game;

public class AttackListener implements ActionListener {
	BattleFrame battle;
	Army playerArmy;
	JButton playerUnit;

	Army defendingArmy;
	JButton defendingUnit;
	Game game;
	WorldMapFrame worldMap;
	public AttackListener(WorldMapFrame worldMap){
		this.worldMap = worldMap;
		this.game = worldMap.getGame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked=(JButton)e.getSource();
		String cityNameClicked= buttonClicked.getActionCommand();
		City attackedCity = null;
		if(cityNameClicked.equals("attack Cairo"))
		{
			attackedCity = this.findCity("Cairo");
			this.playerArmy = this.findArmy("Cairo");
		}	
		else if (cityNameClicked.equals("attack Rome")){
			attackedCity = this.findCity("Rome");
			this.playerArmy = this.findArmy("Rome");
		}
		else if (cityNameClicked.equals("attack Sparta")){
			attackedCity = this.findCity("Sparta");
			this.playerArmy = this.findArmy("Sparta");
		}
		this.defendingArmy = attackedCity.getDefendingArmy();
		this.battle= new BattleFrame(this.worldMap, this.playerArmy,this.defendingArmy);
		
		this.playerUnits();
		this.defenderUnits();
		this.battle.revalidate();
		this.battle.repaint();
		
		this.battle.setVisible(true);
		
	}
	
	public City findCity(String name){
		City c = null;
		for(City current : this.game.getAvailableCities()){
			if(current.getName().equals(name)){
				c= current;
				break;
			}
		}
		return c;
	}
	
	public Army findArmy(String target){
		Army a = null;
		for(Army current : this.game.getPlayer().getControlledArmies()){
			if(current.getCurrentLocation().equals(target)){
				a= current;
				break;
			}
		}
		return a;
	}
	
	public void playerUnits (){
		for(Unit u : this.playerArmy.getUnits()){
			playerUnit = new JButton(u.toString());
			battle.player.add(playerUnit);
		}
	}
	
	public void defenderUnits (){
		for(Unit u : this.defendingArmy.getUnits()){
			defendingUnit = new JButton(u.toString());
			battle.defender.add(defendingUnit);
		}
	}
}
