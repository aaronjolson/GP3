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
 * The context is an obserer for the clock and stores the context info for
 * states
 *
 */
public class VehicleContext {
	private static VehicleDisplay vehicleDisplay;
	private VehicleState currentState;
	private static VehicleContext instance;

	/**
	 * Make it a singleton
	 */
	private VehicleContext() {
		instance = this;
    vehicleDisplay = VehicleDisplay.instance();
		currentState = DriveState.instance();
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static VehicleContext instance() {
		if (instance == null) {
			instance = new VehicleContext();
		}
		return instance;
	}

	/**
	 * lets drive vehicle state be the starting state adds the object as an
	 * observable for clock
	 */
	public void initialize() {
		instance.changeCurrentState(DriveState.instance());
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentState(VehicleState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.run();
	}

	/**
	 * Gets the display
	 * 
	 * @return the display
	 */
	public VehicleDisplay getDisplay() {
		return vehicleDisplay;
	}
}