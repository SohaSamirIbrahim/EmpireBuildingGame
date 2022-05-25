package startView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import worldMapView.WorldMapFrame;
import engine.Game;

public class StartGameListener implements ActionListener {
	protected UserInfoBuilderFrame frame;
	private WorldMapFrame worldMap;
	private Game game;
	
	public StartGameListener(UserInfoBuilderFrame frame ) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = frame.textField.getText();
		String errorMessage = "";
		int index =  frame.citySelector.getSelectedIndex();
		if(text.length()==0) {
			errorMessage += "You must enter name\n";
		}
		if(index==0)
		{
			errorMessage += "You must select a city\n";
		}
		
		
		
		if(errorMessage.length()==0)
		{
			UserInfo userInfo = new UserInfo();
			this.frame.setVisible(false);
			userInfo.setUserName(frame.textField.getText());
			userInfo.setCityName((String) frame.citySelector.getSelectedItem());
			try {
				this.game=new Game(userInfo.getUserName(),userInfo.getCityName());
				this.game.getPlayer().setTreasury(500000);
				this.worldMap = new WorldMapFrame(game);
				this.worldMap.setVisible(true);
			
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		else
		{
			JOptionPane.showMessageDialog(null, errorMessage, "ValidationError", JOptionPane.ERROR_MESSAGE);
		}

	}

}
