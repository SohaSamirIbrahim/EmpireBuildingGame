package units;

import buildings.ArcheryRange;
import buildings.Barracks;
import exceptions.FriendlyFireException;

public abstract class Unit {
	private int level;
	private int maxSoldierCount;
	private int currentSoldierCount;
	private double idleUpkeep;
	private double marchingUpkeep;
	private double siegeUpkeep;
	private Army parentArmy;

	public Unit(int level,int maxSoldierConunt,double idleUpkeep,
				double marchingUpkeep,double siegeUpkeep)
	{
		this.level=level;
		this.maxSoldierCount=maxSoldierConunt;
		this.currentSoldierCount=maxSoldierConunt;
		this.idleUpkeep=idleUpkeep;
		this.marchingUpkeep=marchingUpkeep;
		this.siegeUpkeep=siegeUpkeep;
	}

public abstract void attack(Unit target) throws FriendlyFireException ;
public int getCurrentSoldierCount() {
	return currentSoldierCount;
}
public void setCurrentSoldierCount(int currentSoldierCount) {
	this.currentSoldierCount = currentSoldierCount;
	if(this.currentSoldierCount <= 0)
		this.currentSoldierCount =  0;
}
public int getLevel() {
	return level;
}
public int getMaxSoldierCount() {
	return maxSoldierCount;
}

public double getIdleUpkeep() {
	return idleUpkeep;
}
public double getMarchingUpkeep() {
	return marchingUpkeep;
}

public double getSiegeUpkeep() {
	return siegeUpkeep;
}
public Army getParentArmy() {
	return parentArmy;
}
public void setParentArmy(Army army) {
	this.parentArmy=army;
	
}

	@Override
	public String toString() {
		String type ="";
		if(this instanceof Archer)
			type = "Archers ";
		else if (this instanceof Cavalry)
			type ="Cavalry ";
		else if (this instanceof Infantry)
			type= "Infantry ";
			
		return "Unit{" +
				"Type= " + type +
				"level=" + level +
				", maxSoldierCount=" + maxSoldierCount +
				", currentSoldierCount=" + currentSoldierCount +
				", parentArmy=" + parentArmy +
				'}';
	}
}
