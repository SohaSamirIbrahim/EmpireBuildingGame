package worldMapView;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import units.Army;
import units.Unit;

public class RelocateUnitFrame extends JFrame{
	WorldMapFrame map;
	JLabel unitSelect;
	JPanel unit;
	JLabel armySelect;
	JPanel army;
	JPanel button;
	JComboBox armyUnit;
	JComboBox armySelector;
	
	JButton relocate;
	public RelocateUnitFrame(WorldMapFrame map){
		this.map=map;
		this.setLocation(800,200);
		this.setSize(500, 500);
		this.setResizable(false);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(3,1));
		
		unit= new JPanel(new FlowLayout());
		unitSelect = new JLabel ("Select Unit to relocate");
		unit.add(unitSelect);
		armyUnit = new JComboBox();
		armyUnit.addItem("Select Unit");
		unit.add(armyUnit);
		contentPane.add(unit);
		
		army = new JPanel(new FlowLayout());
		armySelect = new JLabel("Select Army");
		army.add(armySelect);
		armySelector = new JComboBox();
		armySelector.addItem("Select Army");
		army.add(armySelector);
		contentPane.add(army);
		
		button = new JPanel(new FlowLayout());
		
		relocate = new JButton("Relocate");
		relocate.addActionListener(new RelocateListener(this));
		button.add(relocate);
		contentPane.add(button);
		
		this.fillComboBox();	
		
	}
	
	public void fillComboBox(){
		for(Army army : map.game.getPlayer().getControlledArmies()){
			armySelector.addItem(army);
			for(Unit u : army.getUnits()){
				armyUnit.addItem(u);
			}
		}
	}

}
