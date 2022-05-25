package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Farm extends EconomicBuilding {

	public Farm() {
		super(1000, 500);
		this.title="Farm";
	}

	@Override
	public int harvest() {
		if(this.getLevel() == 0)
			return 0;
		if(getLevel()==1)
			return 500;
		else if(getLevel()==2)
			return 700;
		else
			return 1000;
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==0)
		{
			setLevel(1);
			setUpgradeCost(500);
		}
		else  if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(700);
		}
		else if(getLevel()==2)
		{
			setLevel(3);
			
		}
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Farm";
	}

}
