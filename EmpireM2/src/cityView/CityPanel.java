package cityView;

import java.awt.Graphics;

import javax.swing.*;

import buildingView.BuildingInfoFrame;
import buildings.Building;
import engine.City;

public class CityPanel extends JPanel{
	
	protected City city;
	protected CityFrame cityFrame;
	protected BuildingInfoFrame buildingFrame;
	
	public CityFrame getCityFrame() {
		return cityFrame;
	}

	public void setCityFrame(CityFrame cityFrame) {
		this.cityFrame = cityFrame;
	}

	public BuildingInfoFrame getBuildingFrame() {
		return buildingFrame;
	}

	public void setBuildingFrame(BuildingInfoFrame buildingFrame) {
		this.buildingFrame = buildingFrame;
	}

	public CityPanel(CityFrame frame)
	{
		
		this.cityFrame = frame;
		this.city = city;
		
	}
	
	public void handleClick(int x, int y)
	{
		
		if(this.buildingFrame == null)
			this.buildingFrame = new BuildingInfoFrame(this.cityFrame);
		boolean found = false;
		for(Building c: this.city.getMilitaryBuildings())
		{
			if(c.isInside(x, y))
			{
				found = true;
				this.buildingFrame.display(c);
				break;
			}
		}
		if(!found)
		{
			for(Building c: this.city.getEconomicalBuildings())
			{
				if(c.isInside(x, y))
				{
					found = true;
					this.buildingFrame.display(c);
					break;
				}
			}
		}
	}
	
	
	
	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
	}



	public void paint(Graphics g) {
		super.paint(g);
		if(this.city==null)
			return;
		
		for(Building c: this.city.getMilitaryBuildings())
		{
			c.draw(g);
		}
		for(Building c: this.city.getEconomicalBuildings())
		{
			c.draw(g);
		}
		
	}

}
