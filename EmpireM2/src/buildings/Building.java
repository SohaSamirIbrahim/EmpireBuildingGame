package buildings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public abstract class Building {
	
	private int cost;
	private int level;
	private int upgradeCost;
	private boolean coolDown;
	private int x;
	private int y;
	private int width;
	private int hight;
	protected String title;
	

	public Building(int cost,int upgradeCost) {
		this.cost=cost;
		this.upgradeCost=upgradeCost;
		this.level=1;
		coolDown=true;
	}
	
	public  void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		if(coolDown&&level>0)
			throw new BuildingInCoolDownException("Building is in cool down. Wait for the next turn ");
		if(level==3)
			throw new MaxLevelException("Maximum level reached!!");
		
		coolDown=true;
	}

	public int getCost() {
		return cost;
	}

	public int getLevel() {
		return level;
	}

	
	public void setLevel(int level) {
		this.level = level;
	}

	public int getUpgradeCost() {
		if(this.level == 0)
			return this.cost;
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public boolean isCoolDown() {
		return coolDown;
	}

	public void setCoolDown(boolean inCooldown) {
		this.coolDown = inCooldown;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}
	
	public void draw(Graphics g)
	{
//		Image img = ImageIO.read(new File("Building3 Level1.jpg"));
		Image bg2 = (new ImageIcon("Building3 Level1.jpg")).getImage();
		Image bg = (new ImageIcon("Building1 Level1.jpg")).getImage();
		Image bg3 = (new ImageIcon("Building4 Level2.jpg")).getImage();
		Color color = null;
		switch(this.level)
		{
		case 0: color=Color.LIGHT_GRAY; break;
		case 1: g.drawImage(bg, this.x, this.y, null); break;
		case 2: g.drawImage(bg2, this.x, this.y, null); break;
		case 3: g.drawImage(bg3, this.x, this.y, null); break;
		default:color=Color.BLACK;
		}
		
		
		
//		switch(this.level)
//		{
//		case 0: color=Color.LIGHT_GRAY; break;
//		case 1: color=Color.BLUE; break;
//		case 2: color=Color.GREEN; break;
//		case 3: color=Color.RED; break;
//		default:color=Color.BLACK;
//		}
//		g.setColor(color);
//		g.fillRect(this.x,this.y,this.width,this.hight);
//		g.setColor(Color.BLACK);
		g.drawString(title,x+25,y-30);
	
		
	}
	
	public boolean isInside(int x, int y)
	{
		if(x<this.x || x>this.x+this.width)
			return false;
		if(y<this.y || y>this.y+this.hight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Building [level=" + level + ", x=" + x + ", y=" + y + ", width=" + width + ", hight=" + hight + "]";
	}

	public  void upgradeLevel()
	{
		
	}

	public void addUnit() {
		// TODO Auto-generated method stub
		
	}

	public abstract String getTitle();
	
	
	

}
