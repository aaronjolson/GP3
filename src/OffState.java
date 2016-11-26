/**
 * Represents the off state.
 *
 */
public class OffState extends VehicleState
    implements OffRequestListener, TimerRanOutListener, TimerTickedListener, VehicleParkListener {
  private static OffState instance;

  /**
   * Private for the singleton pattern
   */
  private OffState() {
    instance = this;
  }

  /**
   * Removes as a listener from all managers
   *
   */
  public void leave() {
    OffRequestManager.instance().removeOffRequestListener(this);
    TimerRanOutManager.instance().removeTimerRanOutListener(this);
    TimerTickedManager.instance().removeTimerTickedListener(this);
  }

  /**
   * For singleton
   *
   * @return the object
   */
  public static OffState instance() {
    if (instance == null) {
      instance = new OffState();
    }
    return instance;
  }

  /**
   * Process off request
   */
  public void offRequested(OffRequestEvent event) {
//		Timer.instance().addTimeValue(0);
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
    OffRequestManager.instance().addOffRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.turnLightOn();
    Timer.instance().setTimeValue(0);
    display.displayTimeRemaining(Timer.instance().getTimeValue());
  }
}