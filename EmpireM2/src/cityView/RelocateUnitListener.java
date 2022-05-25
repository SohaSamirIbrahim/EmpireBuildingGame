package cityView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import worldMapView.RelocateUnitFrame;
import worldMapView.WorldMapFrame;
import engine.Game;

public class RelocateUnitListener implements ActionListener {
	WorldMapFrame mapFrame;
	RelocateUnitFrame relocate;
	Game game;
	public RelocateUnitListener(WorldMapFrame frame) {
		// TODO Auto-generated constructor stub
		this.mapFrame = frame;
		this.game  = frame.getGame();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		relocate = new RelocateUnitFrame(this.mapFrame);
		relocate.setVisible(true);
	}

}
