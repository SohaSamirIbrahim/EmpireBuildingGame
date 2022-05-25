package battleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import units.Unit;
import engine.Game;
import exceptions.FriendlyFireException;

public class ManualAttackListener implements ActionListener {

	ManualAttackFrame frame;
	
	public ManualAttackListener(ManualAttackFrame frame) {
		this.frame= frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Game game = frame.game;
		int playerIndex = frame.playerUnit.getSelectedIndex();
		if(playerIndex == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Unit");
			return;
		}
		Unit playerUnit = (Unit) frame.playerUnit.getItemAt(playerIndex);
		int oldCount = playerUnit.getCurrentSoldierCount();
		
		int attackedIndex = frame.attackedUnit.getSelectedIndex();
		if(playerIndex == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Unit");
			return;
		}
		Unit attackedUnit = (Unit) frame.attackedUnit.getItemAt(playerIndex);
		int oldCountAttacked = attackedUnit.getCurrentSoldierCount();
		
		int newCount=0;
		int newCountAttacked=0;
		try {
			playerUnit.attack(attackedUnit);
			newCount= playerUnit.getCurrentSoldierCount();
			newCountAttacked = attackedUnit.getCurrentSoldierCount();
		} catch (FriendlyFireException e1) {
			JOptionPane.showMessageDialog(null, "Friendly Fire! ","ERROR", JOptionPane.ERROR_MESSAGE);
		}
		frame.setVisible(false);
		String text = "Your unit lost " + (oldCount-newCount) + " soldiers" + "\n" + "Attacked unit lost " + (oldCountAttacked-newCountAttacked) + " soldiers";
		
		frame.revalidate();
		frame.repaint();
		frame.battleframe.revalidate();
		frame.battleframe.repaint();
		JOptionPane.showMessageDialog(null, text ,"Battle Info", JOptionPane.INFORMATION_MESSAGE);
	}

}
