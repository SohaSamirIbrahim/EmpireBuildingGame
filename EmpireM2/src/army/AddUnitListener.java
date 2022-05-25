package army;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.*;
import exceptions.MaxCapacityException;

import javax.swing.*;

import units.*;
import army.NewArmyFrame;
import buildings.MilitaryBuilding;

public class AddUnitListener implements ActionListener {

	protected NewArmyFrame newArmyFrame;
	
	public AddUnitListener(NewArmyFrame newArmyFrame) {
		this.newArmyFrame = newArmyFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int index = newArmyFrame.unitSelector.getSelectedIndex();
		if(index == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Unit");
			return;
		}
		Unit unit = (Unit ) newArmyFrame.unitSelector.getItemAt(index);
		City city = this.newArmyFrame.cityFrame.getCity();
		Army defendingArmy = city.getDefendingArmy();
		Army createdArmy = this.newArmyFrame.getCreatedArmy();
		if(createdArmy == null)
			createdArmy = this.newArmyFrame.createdArmy();
		if(createdArmy.getUnits().size() == createdArmy.getMaxToHold()) {
			JOptionPane.showMessageDialog(null,  "Max units reached");
		}
		else {
		defendingArmy.getUnits().remove(unit);
		MilitaryBuilding building = null;
		if(unit instanceof Archer)
		{
			building = city.getArcherRange();
		}
		if(unit instanceof Infantry)
		{
			building = city.getBarracks();
		}
		if(unit instanceof Cavalry)
		{
			building = city.getStable();
		}
		if(building == null)
		{
			JOptionPane.showMessageDialog(null, "An error has occured");
			return;
		}
		building.reduceTotal();
		if(createdArmy == null)
			createdArmy = this.newArmyFrame.createdArmy();
		createdArmy.getUnits().add(unit);
		this.newArmyFrame.updateList();
		}

	}


}
