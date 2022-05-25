package worldMapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exceptions.MaxCapacityException;
import units.Army;
import units.Unit;

public class RelocateListener implements ActionListener{

	RelocateUnitFrame frame;
	Unit unit;
	Army army;
	
	public RelocateListener(RelocateUnitFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int unitIndex = frame.armyUnit.getSelectedIndex();
		if(unitIndex == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select a Unit");
			return;
		}
		unit = (Unit) frame.armyUnit.getItemAt(unitIndex);
		Army unitParent = unit.getParentArmy();
		
		int armyIndex = frame.armySelector.getSelectedIndex();
		if(unitIndex == 0)
		{
			JOptionPane.showMessageDialog(null, "Please Select an Army");
			return;
		}
		army = (Army) frame.armySelector.getItemAt(armyIndex);
		
		try {
			if(unit.getParentArmy().equals(army))
				JOptionPane.showMessageDialog(null, "Unit is already in army chosen");
			army.relocateUnit(unit);
			frame.setVisible(false);
			unitParent.getUnits().remove(unit);
			frame.fillComboBox();
//			frame.revalidate();
//			frame.repaint();
		} catch (MaxCapacityException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Max Capacity Reached");
		}
	}
}
