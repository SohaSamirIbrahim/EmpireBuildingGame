package army;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cityView.CityFrame;

public class DisplayNewArmyCloser extends WindowAdapter {

    protected NewArmyFrame newArmyFrame;

    public DisplayNewArmyCloser(NewArmyFrame newArmyFrame)
    {
        this.newArmyFrame = newArmyFrame;
    }


    @Override
    public void windowClosing(WindowEvent event) {
        this.newArmyFrame.setVisible(false);
        this.newArmyFrame.setCreatedArmy(null);
       
        this.newArmyFrame.cityFrame.updateDisplay();
        this.newArmyFrame.getCityFrame().getWorldMap().armySelector.removeAllItems();
        this.newArmyFrame.getCityFrame().getWorldMap().displayInfo();
        
    }



}
