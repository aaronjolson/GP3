
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * GUI to implement the VehicleDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends VehicleDisplay implements ActionListener {
	private static SimpleDisplay frame;

	/**
	 * Makes it a singleton
	 */
	private GUIDisplay() {
		frame = new SimpleDisplay();
		initialize();
	}

	/**
	 * This class has most of the widgets
	 *
	 */
	private class SimpleDisplay extends JFrame {
		private DriveVehicleButton vehicleDriver = new DriveVehicleButton("drive vehicle");
		private VehicleParkButton parkGear = new VehicleParkButton("park vehicle");
		private AccelerateButton accelerateButton = new AccelerateButton("accelerate");
    private BrakeButton brakeButton = new BrakeButton("brake");
		private JLabel doorStatus = new JLabel("drive vehicle");
		private JLabel timerValue = new JLabel("            ");
		private JLabel lightStatus = new JLabel("Light Off");
		private JLabel acceleratingStatus = new JLabel("Not accelerating");

		/**
		 * Sets up the interface
		 */
		private SimpleDisplay() {
			super("Vehicle");
			getContentPane().setLayout(new FlowLayout());
			getContentPane().add(doorStatus);
			getContentPane().add(lightStatus);
			getContentPane().add(timerValue);
			getContentPane().add(acceleratingStatus);
			getContentPane().add(vehicleDriver);
			getContentPane().add(parkGear);
			getContentPane().add(accelerateButton);
      getContentPane().add(brakeButton);
			vehicleDriver.addActionListener(GUIDisplay.this);
			parkGear.addActionListener(GUIDisplay.this);
			accelerateButton.addActionListener(GUIDisplay.this);
      brakeButton.addActionListener(GUIDisplay.this);
			pack();
			setVisible(true);
		}
	}

	/**
	 * Handles the clicks
	 */
	public void actionPerformed(ActionEvent event) {
		((GUIButton) event.getSource()).inform(this);
	}

	/**
	 * Indicate that the light is on
	 */
	public void turnLightOn() {
		frame.lightStatus.setText("Light On");
	}

	/**
	 * Indicate that the light is off
	 */
	public void turnLightOff() {
		frame.lightStatus.setText("Light Off");
	}

	/**
	 * Indicate that the vehicle is in drive
	 */
	public void vehicleDrived() {
		frame.doorStatus.setText("Vehicle in Drive");
	}

	/**
	 * Indicate that the door is opened
	 */
	public void vehicleParked() {
		frame.doorStatus.setText("Vehicle in Park");
	}

	/**
	 * display the remaining time
	 * 
	 * @param value the value remaining
	 */
	public void displayTimeRemaining(int value) {
		frame.timerValue.setText("Current Speed" + " " + value + "mph");
	}

	/**
	 * Indicate that it is accelerating
	 */
	public void startAccelerating() {
		frame.acceleratingStatus.setText("accelerating");
	}

  public void startBraking() {
    frame.acceleratingStatus.setText("braking");
  }

	/**
	 * Indicate that accelerating is done
	 */
	public void notAccelerating() {
		frame.acceleratingStatus.setText("Not accelerating");
	}

	/**
	 * The main method. Creates the interface
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		VehicleDisplay display = new GUIDisplay();
	}
}