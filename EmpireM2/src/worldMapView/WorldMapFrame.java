package worldMapView;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import units.Army;
import battleView.AttackListener;
import battleView.BesiegeListener;
import cityView.CityFrame;
import cityView.RelocateUnitListener;
import engine.City;
import engine.Game;

public class WorldMapFrame extends JFrame {

	public JComboBox armySelector;
	private JButton cairo;
	private JButton sparta;
	private JButton rome;
	public Game game;
	private CityFrame cityFrame;
	private WorldMapListener worldMapListener;
	ControlledArmiesListener controlledArmiesListener;
	ControlledArmiesFrame controlledArmiesFrame;
	AttackListener attackListener;
	BesiegeListener besiegeListener;
	public JButton attackSparta;
	public JButton besiegeSparta;
	public JButton attackCairo;
	public JButton besiegeCairo;
	public JButton attackRome;
	public JButton besiegeRome;
	public JButton relocateUnit;
	
	public WorldMapFrame(Game game){
		
		this.setTitle("World Map");
		this.game = game;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(2,2);
		Container c = getContentPane();
		worldMapListener= new WorldMapListener(this);
		controlledArmiesListener = new ControlledArmiesListener(this);
		besiegeListener= new BesiegeListener(this);
		attackListener = new AttackListener(this);
		try {
			
			JPanelWithBackground worldMapBackground=new JPanelWithBackground("worldmapbg1.jpg");
			worldMapBackground.setLayout(layout);
			
			JPanelWithBackground cairoPanel= new JPanelWithBackground("Cairo.png");
			cairo = new JButton("Cairo");
			cairo.addActionListener(worldMapListener);
			JButton attack = new JButton ("Attack");
			attack.setActionCommand("attack Cairo");
			attack.addActionListener(attackListener);
			
				besiegeCairo= new JButton("Besiege");
				besiegeCairo.setActionCommand("besiegeCairo");
				besiegeCairo.addActionListener(besiegeListener);
				cairoPanel.add(besiegeCairo);
				besiegeCairo.setVisible(false);
				attackCairo = new JButton ("Attack");
				attackCairo.setActionCommand("attack Cairo");
				attackCairo.addActionListener(attackListener);
				cairoPanel.add(attackCairo);
				attackCairo.setVisible(false);
					
			
			cairoPanel.add(cairo);
			worldMapBackground.add(cairoPanel);
			
			JPanelWithBackground romePanel=new JPanelWithBackground("Roma.png");
			rome = new JButton("Rome");
			rome.addActionListener(worldMapListener);
				besiegeRome= new JButton("Besiege");
				besiegeRome.setActionCommand("besiegeRome");
				besiegeRome.addActionListener(besiegeListener);
				romePanel.add(besiegeRome);
				besiegeRome.setVisible(false);
				attackRome = new JButton ("Attack");
				attackRome.setActionCommand("attack Rome");
				attackRome.addActionListener(attackListener);
				romePanel.add(attackRome);
				attackRome.setVisible(false);
				
			romePanel.add(rome);
			worldMapBackground.add(romePanel);
			
			JPanelWithBackground spartaPanel=new JPanelWithBackground("Sparta.png");
			sparta = new JButton("Sparta");
			sparta.addActionListener(worldMapListener);
			
				besiegeSparta= new JButton("Besiege");
				besiegeSparta.setActionCommand("besiegeSparta");
				besiegeSparta.addActionListener(besiegeListener);
				spartaPanel.add(besiegeSparta);
				besiegeSparta.setVisible(false);
				attackSparta = new JButton ("Attack");
				attackSparta.setActionCommand("attack Sparta");
				attackSparta.addActionListener(attackListener);
				spartaPanel.add(attackSparta);
				attackSparta.setVisible(false);
					
			
			spartaPanel.add(sparta);
			worldMapBackground.add(spartaPanel);
			
			
			
			JPanel controlledArmies = new JPanel(new GridLayout(2,1));
			JPanel armyLabel = new JPanel();
			JLabel label = new JLabel("Controlled Armies");
			armyLabel.add(label);
			controlledArmies.add(armyLabel);
			JPanel comboBoxPanel = new JPanel();
			armySelector = new JComboBox();
			armySelector.addItem("Select Army");
			this.displayInfo();
			comboBoxPanel.add(armySelector);
			controlledArmies.add(comboBoxPanel);
			JButton showArmy = new JButton("Show Army Info ");
			showArmy.addActionListener(controlledArmiesListener);
			comboBoxPanel.add(showArmy);
			
			JPanel relocate = new JPanel();
			
			relocateUnit = new JButton("Relocate Unit");
			relocateUnit.addActionListener(new RelocateUnitListener(this));
			c.add(relocateUnit);
			
			controlledArmies.add(relocate);
			
			
			
			
			worldMapBackground.add(controlledArmies);
			c.add(worldMapBackground);

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		controlledArmiesFrame = new ControlledArmiesFrame(this);
		this.setVisible(true);
		
		
	}
	
	public void displayInfo (){
		armySelector.addItem("Select Army");
		for (Army army: this.game.getPlayer().getControlledArmies()){
			this.armySelector.addItem(army);	
		}
	}
	
	public JComboBox getArmySelector() {
		return armySelector;
	}

	public void setArmySelector(JComboBox armySelector) {
		this.armySelector = armySelector;
	}

	public boolean canBesiegeOrAttack(String cityName){
		for(City city:game.getAvailableCities()){
			if(city.getName().equals(cityName)&& !game.getPlayer().getControlledCities().contains(city)){
				//System.out.println("foundRome");
				for(Army army: game.getPlayer().getControlledArmies()){
					
			
					if(army.getCurrentLocation().equals(city.getName())){
						return true;
					}
				}
				
			}
		}
		
		return false;
		
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public JButton getCairo() {
			return cairo;
		}
	
	public JButton getSparta() {
		return sparta;
	}
	
	
	public JButton getRome() {
		return rome;
	}
	


	public void showCity(City city) {
		if(this.cityFrame == null)
			this.cityFrame = new CityFrame(this);
		this.cityFrame.display(city);
		this.cityFrame.setVisible(true);
		
	}
	

}
