package cityView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import units.Army;
import worldMapView.WorldMapFrame;
import army.DisplayNewArmyListener;
import army.NewArmyFrame;
import army.ShowArmyFrame;
import army.ShowArmyListener;
import buildings.ArcheryRange;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Game;
import engine.Player;

public class CityFrame extends JFrame {
	City city;

	CityPanel cityPanel;
	JPanel panel;
	WorldMapFrame worldMap;
	JLabel infoLabel;
	JComboBox armySelector;
	protected NewArmyFrame newArmyFrame;
	ShowArmyFrame showArmyframe;
	ShowArmyListener showArmyListener;
	JButton relocateUnit;
	RelocateUnitListener relocateUnitListener;
	
	public CityFrame(WorldMapFrame map) {

		this.setSize(1525,825);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addWindowListener(new CityFrameCloser(this));
		this.setTitle("City View");
		this.worldMap = map;
		this.setVisible(false);
		this.cityPanel= new CityPanel(this);
		showArmyListener = new ShowArmyListener(this);
		MyMouseListener listener = new MyMouseListener(this.cityPanel);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(cityPanel, BorderLayout.CENTER);
		JPanel controlPanel = new JPanel(new GridLayout(1,3));
		mainPanel.add(controlPanel, BorderLayout.SOUTH);
		JButton nextTurn = new JButton("Next Turn");
		JButton newArmy = new JButton("New Army");
		newArmy.addActionListener(new DisplayNewArmyListener(this));
		this.armySelector = new JComboBox();
		JButton showArmy = new JButton("Show Army");
		showArmy.addActionListener(showArmyListener);
		this.addMouseListener(listener);
		this.cityPanel.addMouseListener(listener);
		nextTurn.addMouseListener(listener);
		newArmy.addMouseListener(listener);
		showArmy.addMouseListener(listener);
		armySelector.addMouseListener(listener);
		JPanel first = new JPanel();
		JPanel second = new JPanel();
		JPanel third = new JPanel(new GridLayout(2,1));
		controlPanel.add(first);
		controlPanel.add(second);
		controlPanel.add(third);
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		third.add(top);
		third.add(bottom);
		bottom.add(armySelector);
		bottom.add(showArmy);
		first.add(nextTurn);
		this.infoLabel = new JLabel("");
		second.add(infoLabel);
		top.add(newArmy);
		nextTurn.addActionListener(new NextTurnListener(this));
		Container contentPane = this.getContentPane();
		contentPane.add(mainPanel);
		this.newArmyFrame = new NewArmyFrame(this);
		this.showArmyframe= new ShowArmyFrame(this);

	}
	
	public ShowArmyFrame getShowArmyframe() {
		return showArmyframe;
	}

	public void setShowArmyframe(ShowArmyFrame showArmyframe) {
		this.showArmyframe = showArmyframe;
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}

	public void setInfoLabel(JLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	public JComboBox getArmySelector() {
		return armySelector;
	}

	public void setArmySelector(JComboBox armySelector) {
		this.armySelector = armySelector;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setNewArmyFrame(NewArmyFrame newArmyFrame) {
		this.newArmyFrame = newArmyFrame;
	}

	public City getCity() {
		return city;
	}





	public void display(City city) {
		this.city = city;
		this.cityPanel.setCity(city);
		updateDisplay();
	}

	public void updateDisplay() {
		Player player = this.worldMap.getGame().getPlayer();
		updateStaticText();
		updateLabelText();
		ArrayList<Army> idleArmies = player.getIdleArmies(city);
		updateArmySelector(idleArmies);
	}

	private void updateArmySelector(ArrayList<Army> idleArmies) {
		this.armySelector.removeAllItems();
		this.armySelector.addItem("Please Select");
		for(Army army: idleArmies)
		{
			this.armySelector.addItem(army);
		}
	}

	private void updateLabelText() {
		String text = "";
		int unitsArchers = 0;
		int unitsCavalery = 0;
		int unitsInfantary = 0;
		int length = this.city.getMilitaryBuildings().size();
		for(int i = 0 ; i < length ; i++) {
		MilitaryBuilding building = this.getCity().getMilitaryBuildings().get(i); 
			if(building instanceof ArcheryRange)
			unitsArchers = building.getTotalRecruit();
			else if(building instanceof Stable)
				unitsCavalery = building.getTotalRecruit();
			else
				unitsInfantary = building.getTotalRecruit();
		}
		text = "<html><strong>Defending Army : </strong> <br>" + " Archer Units =  " + unitsArchers + " <br> " +
				"Cavalery Units =  " + unitsCavalery + " <br> " + "Infantary Units =  " + unitsInfantary + " </html> ";
		infoLabel.setText(text);
		
	}



	public CityPanel getCityPanel() {
		return cityPanel;
	}



	public void setCityPanel(CityPanel cityPanel) {
		this.cityPanel = cityPanel;
	}



	public JPanel getPanel() {
		return panel;
	}



	public void setPanel(JPanel panel) {
		this.panel = panel;
	}



	private void updateStaticText() {
		Player player = this.worldMap.getGame().getPlayer();
		Game game = this.worldMap.getGame();
		this.setTitle("player: " + player.getName() + "  City: " + this.city.getName() +
				"  Gold: " + player.getTreasury() + "  Food: " + player.getFood() +
				"  Turn:" + game.getCurrentTurnCount());

	}



	public WorldMapFrame getWorldMap() {
		return worldMap;
	}



	public void setWorldMap(WorldMapFrame worldMap) {
		this.worldMap = worldMap;
	}

	public NewArmyFrame getNewArmyFrame() {
		return newArmyFrame;
	}
	
	public void draw (Graphics g){
		
	}

}
