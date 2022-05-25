package startView;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import startView.StartGameListener;

public class UserInfoBuilderFrame extends JFrame{
	protected JTextField textField;
	protected JComboBox citySelector;
	
	public UserInfoBuilderFrame() {
		super();
		this.setSize(400,300);
		this.setTitle("Please enter the following info to start");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(3,1);
		Container c = getContentPane();
		c.setLayout(layout);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		c.add(panel1);
		c.add(panel2);
		c.add(panel3);
		textField = new JTextField(20);
		panel1.add(new JLabel("Name"));
		panel1.add(textField);
		panel2.add(new JLabel("City"));
		citySelector = new JComboBox();
		JButton button = new JButton("Start Game");
		StartGameListener handler = new StartGameListener(this);
		panel2.add(citySelector);
		panel3.add(button);
		button.addActionListener(handler);
		
		citySelector.addItem("Select City");
		citySelector.addItem("Cairo");
		citySelector.addItem("Rome");
		citySelector.addItem("Sparta");
		setVisible(true);
	
	}
	
	
	
	

}
