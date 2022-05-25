package battleView;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import units.Army;
import worldMapView.WorldMapFrame;
import engine.Game;

public class BattleFrame extends JFrame{
	Army playerArmy;
	Army defenderArmy;
	JButton manual;
	JButton auto;
	JPanel attackMode;
	JPanel player;
	JPanel defender;
	Game game;
	WorldMapFrame worldMap;
	BattleModeListener battleModeListener;
	public BattleFrame(WorldMapFrame worldMap, Army playerArmy, Army defenderArmy){
		this.worldMap = worldMap;
		this.playerArmy= playerArmy;
		this.defenderArmy=defenderArmy;
		this.game = worldMap.getGame();
		this.setSize(1525,825);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Battle In Progress");
		Container contentPane= getContentPane();
		contentPane.setLayout(new GridLayout(3,1));
		attackMode = new JPanel(new FlowLayout());
		battleModeListener = new BattleModeListener(this);
		manual= new JButton("Manual Attack");
		manual.addActionListener(battleModeListener);
		auto = new JButton("Auto Resolve");
		auto.addActionListener(battleModeListener);
		attackMode.add(manual);
		attackMode.add(auto);
		contentPane.add(attackMode);
		player = new JPanel();
		contentPane.add(player);
		defender = new JPanel();
		contentPane.add(defender);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {

	}
	
	

}
