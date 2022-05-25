package worldMapView;

	import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import startView.UserInfoBuilderFrame;
import engine.Game;

public class WorldPanel extends JPanel{
		private Game game;
		private UserInfoBuilderFrame frame;
		private JButton cairo;
		private JButton rome;
		private JButton sparta;
		private JButton armies;
		public WorldPanel(UserInfoBuilderFrame frame, Game game) {
			this.game=game;
			this.frame= frame;
			GridLayout layout = new GridLayout(1,4);
			Container c = frame.getContentPane();
			c.setLayout(layout);
			cairo= new JButton("Cairo");
			rome= new JButton("Rome");
			sparta= new JButton("Sparta");
			armies= new JButton("Controlled Armies");
		
			this.add(cairo);
			this.add(rome);
			this.add(sparta);
			this.add(armies);
			c.add(this);
			this.setVisible(true);
		}


}
