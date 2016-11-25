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

/**
 * Represents the door opened state
 *
 */
public class VehicleParkState extends VehicleState implements DriveVehicleListener {
	private static VehicleParkState instance;

	private VehicleParkState() {
		instance = this;
	}

	public void leave() {
    DriveVehicleManager.instance().removeDriveVehicleListener(this);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static VehicleParkState instance() {
		if (instance == null) {
			instance = new VehicleParkState();
		}
		return instance;
	}

	/**
	 * Process drive vehicle event
	 */
	@Override
	public void driveVehicle(DriveVehicleEvent event) {
		context.changeCurrentState(DriveVehicleState.instance());

	}

	/**
	 * Initialize the state
	 */
	public void run() {
    DriveVehicleManager.instance().addDriveVehicleListener(this);
		display.turnLightOn();
		display.notAccelerating();
		display.vehicleParked();
		display.displayTimeRemaining(0);
	}

}