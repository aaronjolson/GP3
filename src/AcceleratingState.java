/**
 * Represents the accelerating state.
 */
public class AcceleratingState extends VehicleState
		implements AccelerateRequestListener, BrakeRequestListener, TimerRanOutListener, TimerTickedListener {
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
		AccelerateRequestManager.instance().removeAccelerateRequestListener(instance);
    BrakeRequestManager.instance().removeBrakeRequestListener(instance);
		TimerRanOutManager.instance().removeTimerRanOutListener(instance);
		TimerTickedManager.instance().removeTimerTickedListener(instance);
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
   * Process Accelerate request
   */
  public void brakeRequested(BrakeRequestEvent event) {
    context.changeCurrentState(BrakingState.instance());
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
    AccelerateRequestManager.instance().addAccelerateRequestListener(instance);
    BrakeRequestManager.instance().addBrakeRequestListener(instance);
		TimerRanOutManager.instance().addTimerRanOutListener(instance);
		TimerTickedManager.instance().addTimerTickedListener(instance);
    Timer.instance().setAccelerating(true);
		display.startAccelerating();
		display.displaySpeed(Timer.instance().getSpeed());
	}
}