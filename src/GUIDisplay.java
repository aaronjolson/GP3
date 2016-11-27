
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
 * GUI to implement the VehicleDisplay interface. A pretty elementary interface
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
	 * This class has most of the widgets.
	 *
	 */
	private class SimpleDisplay extends JFrame {
    private OffButton offButton = new OffButton("off");
    private OnButton onButton = new OnButton("on");
		private DriveButton driveGear = new DriveButton("drive");
		private ParkButton parkGear = new ParkButton("park");
		private AccelerateButton accelerateButton = new AccelerateButton("accelerate");
    private BrakeButton brakeButton = new BrakeButton("brake");
		private JLabel gearStatus = new JLabel("drive");
		private JLabel speedValue = new JLabel("                                " +
        "                                  ");
		private JLabel vehicleStatus = new JLabel("Vehicle Off");
		private JLabel acceleratingStatus = new JLabel("Not accelerating");

		/**
		 * Sets up the interface
		 */
		private SimpleDisplay() {
			super("Vehicle");
			getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
      getContentPane().add(vehicleStatus);
      getContentPane().add(gearStatus);
			getContentPane().add(speedValue);
			getContentPane().add(acceleratingStatus);
      getContentPane().add(offButton);
      getContentPane().add(onButton);
			getContentPane().add(driveGear);
			getContentPane().add(parkGear);
      getContentPane().add(brakeButton);
			getContentPane().add(accelerateButton);
			driveGear.addActionListener(GUIDisplay.this);
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
	public void turnVehicleOn() {
		frame.vehicleStatus.setText("Vehicle On");
	}

	/**
	 * Indicate that the light is off
	 */
	public void turnVehicleOff() {
		frame.vehicleStatus.setText("Vehicle Off");
	}

	/**
	 * Indicate that the vehicle is in drive
	 */
	public void driveVehicle() {
		frame.gearStatus.setText("Vehicle in Drive");
	}

	/**
	 * Indicate that the door is opened
	 */
	public void vehicleParked() {
		frame.gearStatus.setText("Vehicle in Park");
	}

	/**
	 * display the remaining time
	 * 
	 * @param value the value remaining
	 */
	public void displayTimeRemaining(int value) {
		frame.speedValue.setText("Current Speed" + " " + value + "mph");
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