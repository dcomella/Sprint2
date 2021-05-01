package waiter;

import java.awt.*;
import javax.swing.*;

class Main extends JFrame {
	GridBagLayout gbl = new GridBagLayout();
	int x;
	int y;
	
	
	Main() {
		setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1300,800);
		setLocationRelativeTo(null);

		//(GridBagLayout, JComponent, width, height, x, y, weightx, weighty)
		
		String[] keysY = { "1", "2", "3", "4", "5", "6" };
		y = 0;
		for(String key : keysY) {
			y++;
			BorderPanel panel = new BorderPanel(key);
			add(panel);
									 	//	 w, h, x, y
			makeConstraints(gbl, panel,		 1, 1, 0, y, 1.0, 1.0);
		}
				
		String[] keysX = { "A", "B", "C", "D", "E", "F" };
		x = 0;
		for(String key : keysX) {
			x++;
			BorderPanel panel = new BorderPanel(key);
			add(panel);
										//	w, h, x, y
			makeConstraints(gbl, panel, 	1, 1, x, 7, 1.0, 1.0);
		}
		
		x = 0;
		for(String keyX : keysX) {
			x++;
			for(String keyY : keysY) {
				BorderPanel panel = new BorderPanel(keyY + keyX);
				add(panel);
				makeConstraints(gbl, panel, 1, 1, x, Integer.parseInt(keyY), 1.0, 1.0);
			}
		}

		BorderPanel headerName = new BorderPanel("");
		headerName.add(new JLabel("Name: Rosa Smith"));
		BorderPanel headerID = new BorderPanel("");
		headerID.add(new JLabel("ID: 32424989"));
		BorderPanel headerTime = new BorderPanel("");
		headerTime.add(new JLabel("10:21AM 4/27/2021"));
		
		add(headerName);
		add(headerID);
		add(headerTime);
										//	w, h, x, y
		makeConstraints(gbl, headerName, 	2, 1, 1, 0, 1.0, .1);
		makeConstraints(gbl, headerID, 		2, 1, 3, 0, 1.0, .1);
		makeConstraints(gbl, headerTime, 	2, 1, 5, 0, 1.0, .1);
		
		BorderPanel sideBar = new BorderPanel("SideBar");
		
		add(sideBar);
										//	w, h, x, y
		makeConstraints(gbl, sideBar, 		1, 7, 8, 0, 3.0, 1.0);
	}

	/**
	  * Generate constraints for Swing components
	  * @param gbl     a gridbaglayout that used to embed Swing component
	  * @param comp    a Swing component intended to be embedded in gbl
	  * @param w       desired component width
	  * @param h       desired component height
	  * @param x       desired location in x-axis
	  * @param y       desired location in y-axis
	  * @param weightx desired weight in terms of x-axis
	  * @param weighty desired weight in terms of y-axis
	  */
	public void makeConstraints(GridBagLayout gbl, JComponent comp, int w, int h, int x, int y,
			double weightx, double weighty) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		gbl.setConstraints(comp, constraints);
	}

	//Main method
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}

class BorderPanel extends JPanel {
	BorderPanel(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
	}
}
