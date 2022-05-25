package army;

import engine.City;
import engine.Player;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cityView.CityFrame;
import units.Army;
import units.Unit;

public class NewArmyFrame extends JFrame{
	protected JComboBox unitSelector;
	CityFrame cityFrame;
	protected Army createdArmy;
	private City city;

	public NewArmyFrame(CityFrame cityFrame) {
		super();
		this.setLocation(20,100);
		this.setSize(300,200);
		this.cityFrame = cityFrame;
		Container contentPane = this.getContentPane();
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel);
		unitSelector = new JComboBox();
		mainPanel.add(unitSelector);
		JButton button = new JButton("Add Unit");
		mainPanel.add(button);
		AddUnitListener handler = new AddUnitListener(this);
		button.addActionListener(handler);
		this.addWindowListener(new DisplayNewArmyCloser(this));
	}

	public JComboBox getUnitSelector() {
		return unitSelector;
	}

	public void setUnitSelector(JComboBox unitSelector) {
		this.unitSelector = unitSelector;
	}

	public CityFrame getCityFrame() {
		return cityFrame;
	}

	public void setCityFrame(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setCreatedArmy(Army createdArmy) {
		this.createdArmy = createdArmy;
	}

	public void display(City city)
	{
		this.city = city;
		updateList();
	}

	public Army getCreatedArmy() {
		return createdArmy;
	}

	public Army createdArmy() {
		this.createdArmy = new Army(this.cityFrame.getCity().getName());
		Player player = this.cityFrame.getWorldMap().getGame().getPlayer();
		player.getControlledArmies().add(createdArmy);
		return  this.createdArmy;
	}


	public void updateList() {
		Army defendingArmy = city.getDefendingArmy();
		ArrayList<Unit> units =  defendingArmy.getUnits();
		this.unitSelector.removeAllItems();
		this.unitSelector.addItem("Please Select");
		for(Unit unit: units)
		{
			this.unitSelector.addItem(unit);
		}
	}
}
