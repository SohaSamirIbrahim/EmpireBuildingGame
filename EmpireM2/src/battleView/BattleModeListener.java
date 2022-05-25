package battleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import units.Army;
import units.Unit;
import engine.City;
import engine.Game;
import exceptions.FriendlyFireException;

public class BattleModeListener implements ActionListener {
	BattleFrame battle;
	Army playerArmy;
	Army defendingArmy;
	Game game;
	ManualAttackFrame manualAttack;
	public BattleModeListener(BattleFrame battle){
		this.battle = battle;
		this.game = battle.game;
		this.playerArmy= battle.playerArmy;
		this.defendingArmy = battle.defenderArmy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked=(JButton)e.getSource();
		String battleMode= buttonClicked.getText();
		if(battleMode.equals("Manual Attack")){
			manualAttack = new ManualAttackFrame(this.battle,this.game,this.playerArmy, this.defendingArmy);
			manualAttack.setVisible(true);
		}
		else if(battleMode.equals("Auto Resolve")){
//			this.autoResolve1(this.playerArmy, this.defendingArmy);
		}
				
	}
	
//	public void autoResolve1(Army player, Army defender){
//		try {
//			battle.game.autoResolve(player, defender);
//			
//			
//		} catch (FriendlyFireException e) {
//			JOptionPane.showMessageDialog(null, "Friendly Fire! ","ERROR", JOptionPane.ERROR_MESSAGE);
//		}
//	
//		
//		if(player.getUnits().size()< defender.getUnits().size())
//			JOptionPane.showMessageDialog(null, "YOU LOST ","Battle Lost", JOptionPane.INFORMATION_MESSAGE);
//		else
//			JOptionPane.showMessageDialog(null, "YOU WON THE BATTLE! ","Winner", JOptionPane.INFORMATION_MESSAGE);
//		battle.setVisible(false);
//		
//		
//	}
//	
	
	
	
}
