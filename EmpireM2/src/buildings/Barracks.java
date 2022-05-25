package buildings;


import units.Infantry;
import units.Unit;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;

public class Barracks extends MilitaryBuilding {

	public Barracks() {
		//(int cost, int upgradeCost,int recruitmentCost)
		super(2000, 1000,500);
		this.title="Barracks";
	}

	@Override
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if(isCoolDown())
			throw new BuildingInCoolDownException("Building is cooling down, please wait for the next turn");
		if(getCurrentRecruit()==getMaxRecruit())
			throw new MaxRecruitedException("Max recruited units reached, please wait till next turn. ");
		setCurrentRecruit(getCurrentRecruit()+1);
		this.setTotalRecruit(this.getTotalRecruit()+1);
		if(getLevel()==1)
			return new Infantry(1, 50, 0.5, 0.6, 0.7);
		
	else if(getLevel()==2)
		return new Infantry(2,50,0.5,0.6,0.7);
	else
		return new Infantry(3,60,0.6,0.7,0.8);
		
		
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==0)
		{
			setLevel(1);
			setUpgradeCost(1000);
			setRecruitmentCost(500);
		}
		else if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(1500);
			setRecruitmentCost(550);
		}
		else if(getLevel()==2)
		{
		setLevel(3);
		setRecruitmentCost(600);
		}
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Barracks";
	}


}
