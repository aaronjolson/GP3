/**
 * Represents the braking state.
 *
 */
public class BrakingState extends VehicleState
    implements BrakeRequestListener, TimerRanOutListener, TimerTickedListener, VehicleParkListener {
  private static BrakingState instance;

  /**
   * Private for the singleton pattern
   */
  private BrakingState() {
    instance = this;
  }

  /**
   * Removes as a listener from all managers
   *
   */
  public void leave() {
    BrakeRequestManager.instance().removeBrakeRequestListener(this);
    TimerRanOutManager.instance().removeTimerRanOutListener(this);
    TimerTickedManager.instance().removeTimerTickedListener(this);
  }

  /**
   * For singleton
   *
   * @return the object
   */
  public static BrakingState instance() {
    if (instance == null) {
      instance = new BrakingState();
    }
    return instance;
  }

  /**
   * Process brake request
   */
  public void brakeRequested(BrakeRequestEvent event) {
    display.displayTimeRemaining(Timer.instance().getTimeValue());
  }

  /**
   * Process door open request
   */
  public void vehicleParked(VehicleParkEvent event) {
    context.changeCurrentState(VehicleParkState.instance());
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
    context.changeCurrentState(DriveVehicleState.instance());
  }

  /**
   * Initializes the state Adds itself as a listener to managers Updates the
   * dosplays
   *
   */
  public void run() {
    VehicleParkManager.instance().addVehicleParkListener(this);
    BrakeRequestManager.instance().addBrakeRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.turnLightOn();
    Timer.instance().setTimeValue(0);
    Timer.instance().setAccelerating(false);
//    display.startBraking();
    display.displayTimeRemaining(Timer.instance().getTimeValue());
  }
}