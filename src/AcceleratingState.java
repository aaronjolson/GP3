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
 * Represents the accelerating state.
 *
 */
public class AcceleratingState extends VehicleState
		implements AccelerateRequestListener, TimerRanOutListener, TimerTickedListener, ParkListener {
	private static AcceleratingState instance;

	/**
	 * Private for the singleton pattern
	 */
	private AcceleratingState() {
		instance = this;
	}

	/**
	 * Removes as a listener from all managers
	 * 
	 */
	public void leave() {
		AccelerateRequestManager.instance().removeAccelerateRequestListener(this);
		TimerRanOutManager.instance().removeTimerRanOutListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static AcceleratingState instance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	/**
	 * Process Accelerate request
	 */
	public void accelerateRequested(AccelerateRequestEvent event) {
//		Timer.instance().addTimeValue(0);
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process door open request
	 */
	public void vehicleParked(ParkEvent event) {
		context.changeCurrentState(ParkState.instance());
	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void timerTicked(TimerTickedEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void timerRanOut(TimerRanOutEvent event) {
		display.displayTimeRemaining(Timer.instance().getTimeValue());
		context.changeCurrentState(DriveState.instance());
	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * dosplays
	 * 
	 */
	public void run() {
    ParkManager.instance().addVehicleParkListener(this);
    AccelerateRequestManager.instance().addAccelerateRequestListener(this);
		TimerRanOutManager.instance().addTimerRanOutListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		display.turnLightOn();
		Timer.instance().setTimeValue(0);
    Timer.instance().setAccelerating(true);
		display.startAccelerating();
		display.displayTimeRemaining(Timer.instance().getTimeValue());
	}
}