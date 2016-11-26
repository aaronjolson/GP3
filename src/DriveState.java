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
public class DriveState extends VehicleState implements AccelerateRequestListener, BrakeRequestListener, VehicleParkListener {
	private static DriveState instance;

	private DriveState() {
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
	public static DriveState instance() {
		if (instance == null) {
			instance = new DriveState();
		}
		return instance;
	}

	/**
	 * handle park event
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

  @Override
  public void brakeRequested(BrakeRequestEvent event) {
    context.changeCurrentState(BrakingState.instance());
  }

	/**
	 * initialize the state
	 * 
	 */
	public void run() {
    AccelerateRequestManager.instance().addAccelerateRequestListener(instance);
    BrakeRequestManager.instance().addBrakeRequestListener(instance);
    VehicleParkManager.instance().addVehicleParkListener(instance);
		display.vehicleDrived();
		display.turnLightOff();
		display.notAccelerating();
		display.displayTimeRemaining(0);
		Timer.instance().setTimeValue(0);
	}
}