package buildingView;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cityView.CityFrame;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;

public class BuildingInfoFrame extends JDialog {
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	protected JLabel costLabel;
	JButton upgradeButton;
	JButton unit1;
	JButton unit2;
	JButton unit3;
	Building currentBuilding;
	JLabel levelLabel;
	JLabel message;
	JButton upgradeBuilding;
	JButton addUnit;
	CityFrame cityFrame;
	
	public CityFrame getCityFrame() {
		return cityFrame;
	}


	public void setCityFrame(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}


	public BuildingInfoFrame(CityFrame cityFrame)
	{
		this.setSize(500, 400);
		this.cityFrame = cityFrame;
		this.setResizable(false);
		this.setVisible(true);
		this.setModal(false);
		GridLayout layout = new GridLayout(6,1);
		Container c = getContentPane();
		c.setLayout(layout);
		panel1 = new JPanel();
	    panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel1.setVisible(true);
		panel2.setVisible(true);
		panel3.setVisible(true);
		panel4.setVisible(true);
		panel5.setVisible(true);
		panel6.setVisible(true);
		upgradeButton = new JButton("Upgrade");
		BuildingInfoUpgradeListener handler = new BuildingInfoUpgradeListener(this);
		upgradeButton.addActionListener(handler);
		this.levelLabel = new JLabel(" ");
		this.costLabel = new JLabel("Cost per Unit");
		panel1.add(levelLabel);
		panel1.add(upgradeButton);
		this.message = new JLabel(" ");
		panel2.add(message);
		JButton button2 = new JButton("Show Unit");
		JLabel label1 = new JLabel("Recruit");
	    unit1 = new JButton("1 Unit");
		unit2 = new JButton("2 Units");
		unit3 = new JButton("3 Units");
		BuildingInfoRecuiteListener listener = new BuildingInfoRecuiteListener(this);
		this.unit1.addActionListener(listener);
		this.unit2.addActionListener(listener);
		this.unit3.addActionListener(listener);
		JButton button7 = new JButton("OK");
		button7.addActionListener(new OkButtonListener(this));
		panel4.add(label1);
		panel4.add(unit1);
		panel4.add(unit2);
		panel4.add(unit3);
		panel5.add(costLabel);
		panel6.add(button7);
		c.add(panel1);
		c.add(panel2);
		c.add(panel4);
		c.add(panel5);
		c.add(panel6);
		this.setVisible(true);
		
	}
	
	
	public Building getCurrentBuilding() {
		return currentBuilding;
	}


	public void setCurrentBuilding(Building currentBuilding) {
		this.currentBuilding = currentBuilding;
	}


	public void display(Building building)
	{
		if(building.getLevel() == 0)
			this.upgradeButton.setText("BUILD");
		else
			this.upgradeButton.setText("Upgrade");
		String title = building.getTitle();
		this.currentBuilding = building;
		this.setTitle(title);
		if(building instanceof MilitaryBuilding)
		{
			displayMilitaryBuilding((MilitaryBuilding) building );
		}
		if(building instanceof EconomicBuilding)
		{
			displayEconomicBuilding((EconomicBuilding) building );
		}
		
		
		this.setVisible(true);
	}
	private void displayMilitaryBuilding(MilitaryBuilding building){
		this.panel3.setVisible(true);
		if(building.getLevel()==0)
			this.panel4.setVisible(false);
		else
			this.panel4.setVisible(true);
		this.panel5.setVisible(true);
		if(building.getLevel() == 0)
			this.levelLabel.setText("Level  " + building.getLevel() +
				"  Build Cost  " + building.getUpgradeCost());
		else
			this.levelLabel.setText("Level  " + building.getLevel() +
					"  Upgrade Cost  " + building.getUpgradeCost());
		this.message.setText("Units Total " +building.getTotalRecruit()+
				" Current " + building.getCurrentRecruit());
		this.costLabel.setText("Cost Per Unit  " + building.getRecruitmentCost());
		if(building.getLevel()==3)
			this.upgradeButton.setVisible(false);
		if(building.getLevel()==0)
		{
			this.panel4.setVisible(false);
		}
		else
		{
			this.panel4.setVisible(true);
		}
	}

	private void displayEconomicBuilding(EconomicBuilding building){
		this.panel3.setVisible(false);
		this.panel4.setVisible(false);
		this.panel5.setVisible(false);
		this.levelLabel.setText("Level  " + building.getLevel());
		int harvest = building.harvest();
		this.message.setText("Harvest  " + harvest);
		if(building.getLevel()==3)
			this.upgradeButton.setVisible(false);
	}
	

	public JButton getAddUnit() {
		return addUnit;
	}


	public void setAddUnit(JButton addUnit) {
		this.addUnit = addUnit;
	}
	
}
