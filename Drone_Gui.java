import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class Drone_Gui {
	
	static Drone currentDrone = new Drone();
	static JTextPane droneCoord = new JTextPane();
	
	public static void main(String args[]) {
		createGuiFrame();
	}
	
	static void createGuiFrame() {
		
		
		JFrame frame = new JFrame("Drone Controls");
		frame.setSize(330,180);
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		
		//Create up button, add it to the panel, and create the action listener
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 4;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		JButton upButton = new JButton("Up");
		panel.add(upButton, constraints);
		upButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneYPosition(currentDrone.getDroneYPosition() + 1);
				updateDroneCoordText();
			}
		});
		
		//Create up forward, add it to the panel, and create the action listener
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		JButton forwardButton = new JButton("Forward");
		panel.add(forwardButton, constraints);
		forwardButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneZPosition(currentDrone.getDroneZPosition() + 1);
				updateDroneCoordText();
			}
		});
		
		//Create left button, add it to the panel, and create the action listener
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		JButton leftButton = new JButton("Left");
		panel.add(leftButton, constraints);
		leftButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneXPosition(currentDrone.getDroneXPosition() - 1);
				updateDroneCoordText();
			}
		});
		
		//Create the field that contains the drone coords and add it to the panel
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		droneCoord.setText(currentDrone.retrieveDronePosition());
		panel.add(droneCoord, constraints);
		
		//Create right button, add it to the panel, and create the action listener
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		JButton rightButton = new JButton("Right");
		panel.add(rightButton, constraints);
		rightButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneXPosition(currentDrone.getDroneXPosition() + 1);
				updateDroneCoordText();
			}
		});
		
		//Create backward button, add it to the panel, and create the action listener
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		JButton backwardButton = new JButton("Backward");
		panel.add(backwardButton, constraints);
		backwardButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneZPosition(currentDrone.getDroneZPosition() - 1);
				updateDroneCoordText();
			}
		});
		
		//Create down button, add it to the panel, and create the action listener
		constraints.gridx = 4;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		JButton downButton = new JButton("Down");
		panel.add(downButton, constraints);
		downButton.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent event)
			{
				currentDrone.setDroneYPosition(currentDrone.getDroneYPosition() - 1);
				updateDroneCoordText();
			}
		});
		
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	static void updateDroneCoordText()
	{
		droneCoord.setText(currentDrone.retrieveDronePosition());
	}

}


