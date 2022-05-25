package worldMapView;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.City;

public class ControlledArmiesFrame extends JFrame{
	JPanel armyInfo;
	JLabel armyLabel;
	JPanel unitInfo;
	JLabel unitLabel;
	JButton target;
	WorldMapFrame map;
	ControlledArmiesListener listener;
	SetTargetListener targetListener;
	JComboBox targetSelector;
	
	public ControlledArmiesFrame(WorldMapFrame map){
		this.map=map;
		this.setLocation(800,200);
		this.setSize(500, 500);
		this.setResizable(false);
		Container contentPane = this.getContentPane();
		armyInfo= new JPanel();
		unitInfo = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.add(armyInfo);
		mainPanel.add(unitInfo);
		contentPane.add(mainPanel);
		
		armyLabel = new JLabel();
		armyInfo.add(armyLabel);
		armyInfo.setVisible(true);
		target = new JButton ("Set Target ");
		armyInfo.add(target);
		targetListener = new SetTargetListener (this);
		target.addActionListener(targetListener);
		unitLabel = new JLabel();
		unitInfo.add(unitLabel);
		unitInfo.setVisible(true);
		targetSelector = new JComboBox();
		targetSelector.addItem("Select target");
		this.target();
		armyInfo.add(targetSelector);
		
		
	}
	
	public void target(){
		for(City availableCity : this.map.getGame().getAvailableCities()){
			this.targetSelector.addItem(availableCity.getName());
		}
	}
	

}
