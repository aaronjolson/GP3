/**
 * Represents the accelerating state.
 */
public class AcceleratingState extends VehicleState
		implements AccelerateRequestListener, TimerRanOutListener, TimerTickedListener {
	private static AcceleratingState instance;

	/**
	 * Private for the singleton pattern
	 */
	private AcceleratingState() {
		instance = this;
	}

	/**
	 * Removes listeners from managers
	 */
	public void leave() {
		AccelerateRequestManager.instance().removeAccelerateRequestListener(this);
		TimerRanOutManager.instance().removeTimerRanOutListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
	}

	/**
	 * For creating instance as singleton
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
		display.displaySpeed(Timer.instance().getSpeed());
	}


	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void timerTicked(TimerTickedEvent event) {
		display.displaySpeed(Timer.instance().getSpeed());
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void timerRanOut(TimerRanOutEvent event) {
		display.displaySpeed(Timer.instance().getSpeed());
		context.changeCurrentState(DriveState.instance());
	}

	/**
	 * Initializes the state Adds itself as a listener to managers.
   * Updates the displays.
	 *
	 */
	public void run() {
    AccelerateRequestManager.instance().addAccelerateRequestListener(this);
		TimerRanOutManager.instance().addTimerRanOutListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
    Timer.instance().setAccelerating(true);
		display.startAccelerating();
		display.displaySpeed(Timer.instance().getSpeed());
	}
}