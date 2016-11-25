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
 * Represents the drive vehicle state
 *
 */
public class DriveVehicleState extends VehicleState implements AccelerateRequestListener, VehicleParkListener {
	private static DriveVehicleState instance;

	private DriveVehicleState() {
		instance = this;
	}

	public void leave() {
    AccelerateRequestManager.instance().removeAccelerateRequestListener(instance);
    VehicleParkManager.instance().removeVehicleParkListener(instance);
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static DriveVehicleState instance() {
		if (instance == null) {
			instance = new DriveVehicleState();
		}
		return instance;
	}

	/**
	 * handle door open event
	 * 
	 */

	@Override
	public void vehicleParked(VehicleParkEvent event) {
		context.changeCurrentState(VehicleParkState.instance());
	}

	/**
	 * handle accelerate request
	 * 
	 */

	@Override
	public void accelerateRequested(AccelerateRequestEvent event) {
		context.changeCurrentState(AcceleratingState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	public void run() {
    AccelerateRequestManager.instance().addAccelerateRequestListener(instance);
    VehicleParkManager.instance().addVehicleParkListener(instance);
		display.vehicleDrived();
		display.turnLightOff();
		display.notAccelerating();
		display.displayTimeRemaining(0);
		Timer.instance().setTimeValue(0);
	}
}