package army;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cityView.CityFrame;

public class ShowArmyFrame extends JFrame{
	CityFrame cityFrame;
	JComboBox ArmySelector;
	JLabel label;
	
	public ShowArmyFrame(CityFrame cityFrame) {
		super();
		this.cityFrame= cityFrame;
		this.setSize(600,400);
		GridLayout layout = new GridLayout(1,1);
		Container c = this.getContentPane();
		c.setLayout(layout);
		JPanel panel1 = new JPanel();
		label= new JLabel(" ");
		panel1.add(label);
		c.add(panel1);
	
		
	}

	public CityFrame getCityFrame() {
		return cityFrame;
	}

	public void setCityFrame(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}

	public JComboBox getArmySelector() {
		return ArmySelector;
	}

	public void setArmySelector(JComboBox armySelector) {
		ArmySelector = armySelector;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	

}
