/**
 * Represents the off state.
 *
 */
public class OffState extends VehicleState
    implements OffRequestListener, TimerRanOutListener, TimerTickedListener, ParkListener {
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
    display.displaySpeed(Timer.instance().getSpeed());
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
   * Initializes the state Adds itself as a listener to managers. Updates the
   * displays
   *
   */
  public void run() {
    ParkRequestManager.instance().addVehicleParkListener(this);
    OffRequestManager.instance().addOffRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.turnVehicleOff();
    Timer.instance().setSpeed(0);
    display.displaySpeed(Timer.instance().getSpeed());
  }
}