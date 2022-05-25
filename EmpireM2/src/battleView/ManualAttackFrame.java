package battleView;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import units.Army;
import units.Unit;
import engine.Game;

public class ManualAttackFrame extends JFrame {
	BattleFrame battleframe;
	JPanel main;

	JComboBox playerUnit;
	JComboBox attackedUnit;
	Game game;
	Army playerArmy;
	Army defenderArmy;
	ManualAttackListener manualListener;
	JButton attack;
	public ManualAttackFrame(BattleFrame battle,Game game, Army playerArmy, Army defenderArmy){
		this.battleframe = battle;
		this.game=game;
		this.playerArmy= playerArmy;
		this.defenderArmy= defenderArmy;
		this.setLocation(800,200);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		main= new JPanel(new FlowLayout());
		JLabel player = new JLabel("Your Unit");
		main.add(player);
		playerUnit = new JComboBox();
		playerUnit.addItem("Select Your Unit");
		this.playerUnits();
		main.add(playerUnit);
		
		JLabel attacked = new JLabel("Attacked Unit");
		main.add(attacked);
		attackedUnit = new JComboBox();
		attackedUnit.addItem("Select Attacked Unit");
		this.attackedUnits();
		main.add(attackedUnit);
		
		attack= new JButton("Attack");
		manualListener = new ManualAttackListener(this);
		attack.addActionListener(manualListener);
		main.add(attack);
		
		contentPane.add(main);
	}
	
	public void playerUnits(){
		for(Unit u : this.playerArmy.getUnits()){
			playerUnit.addItem(u);
		}
	}
	
	public void attackedUnits(){
		for(Unit a : this.defenderArmy.getUnits()){
			attackedUnit.addItem(a);
		}
	}

}
