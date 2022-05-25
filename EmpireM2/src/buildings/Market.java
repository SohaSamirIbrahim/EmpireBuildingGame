package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Market extends EconomicBuilding {

	public Market() {
		super(1500, 700);
		this.title="Market";
	}

	@Override
	public int harvest() {
		if(this.getLevel() == 0)
			return 0;
		if(getLevel()==1)
			return 1000;
		else if(getLevel()==2)
			return 1500;
		else
			return 2000;
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==0)
		{
			setLevel(1);
			setUpgradeCost(700);
		}
		else if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(1000);
		}
		else if(getLevel()==2)
		setLevel(3);
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Market";
	}

}
