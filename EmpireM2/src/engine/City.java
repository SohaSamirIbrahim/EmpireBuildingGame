package engine;
import java.util.ArrayList;

import units.Army;
import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;

public class City {
	private String name;
private ArrayList<EconomicBuilding> economicalBuildings;
private ArrayList<MilitaryBuilding> militaryBuildings;
private Army defendingArmy;
private int turnsUnderSiege;
private boolean underSiege;

	public City(String name) {
		this.name=name;
		economicalBuildings= new ArrayList<EconomicBuilding>();
		militaryBuildings= new ArrayList<MilitaryBuilding>();
		defendingArmy= new Army(name);
		turnsUnderSiege=-1;
		initBuildings();
	}
	
	private void initBuildings()
	{
		ArcheryRange range = new ArcheryRange();
		range.setLevel(0);
		range.setX(400);
		range.setY(100);
		range.setWidth(200);
		range.setHight(150);
		this.militaryBuildings.add(range);
		Barracks barrack = new Barracks();
		barrack.setLevel(0);
		barrack.setX(100);
		barrack.setY(100);
		barrack.setWidth(200);
		barrack.setHight(150);
		this.militaryBuildings.add(barrack);
		Stable stable = new Stable();
		stable.setLevel(0);
		stable.setX(250);
		stable.setY(350);
		stable.setWidth(200);
		stable.setHight(150);
		this.militaryBuildings.add(stable);
		Market market = new Market();
		market.setLevel(0);
		market.setX(800);
		market.setY(250);
		market.setWidth(200);
		market.setHight(150);
		this.economicalBuildings.add(market);
		Farm farm = new Farm();
		farm.setLevel(0);
		farm.setX(1100);
		farm.setY(250);
		farm.setWidth(200);
		farm.setHight(150);
		this.economicalBuildings.add(farm);
		
		
		
	}
	
	public ArrayList<EconomicBuilding> getEconomicalBuildings() {
		return economicalBuildings;
	}
	
	public ArrayList<MilitaryBuilding> getMilitaryBuildings() {
		return militaryBuildings;
	}
	
	public Army getDefendingArmy() {
		return defendingArmy;
	}
	//to be removed
	public void setDefendingArmy(Army defendingArmy)  {
		this.defendingArmy = defendingArmy;
	}
	public int getTurnsUnderSiege() {
		return turnsUnderSiege;
	}
	public void setTurnsUnderSiege(int turnsUnderSiege) {
		this.turnsUnderSiege = turnsUnderSiege;
	}
	public String getName()
	{
		return this.name;
	}
	public boolean isUnderSiege() {
		return underSiege;
	}
	public void setUnderSiege(boolean underSiege) {
		this.underSiege = underSiege;
	}


    public MilitaryBuilding getArcherRange() {
		for(MilitaryBuilding b: this.militaryBuildings)
		{
			if(b instanceof ArcheryRange)
				return b;
		}
		return null;
    }

	public MilitaryBuilding getBarracks() {
		for(MilitaryBuilding b: this.militaryBuildings)
		{
			if(b instanceof Barracks)
				return b;
		}
		return null;
	}

	public MilitaryBuilding getStable() {
		for(MilitaryBuilding b: this.militaryBuildings)
		{
			if(b instanceof Stable)
				return b;
		}
		return null;
	}

	public EconomicBuilding getFarm() {
		for(EconomicBuilding b: this.economicalBuildings)
		{
			if(b instanceof Farm)
				return b;
		}
		return null;
	}

	public EconomicBuilding getMarket() {
		for(EconomicBuilding b: this.economicalBuildings)
		{
			if(b instanceof Market)
				return b;
		}
		return null;
	}
	
	
}
