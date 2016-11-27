/**
 * Represents the on state.
 *
 */
public class OnState extends VehicleState
    implements OnRequestListener, TimerRanOutListener, TimerTickedListener, ParkListener {
  private static OnState instance;

  /**
   * Private for the singleton pattern
   */
  private OnState() {
    instance = this;
  }

  /**
   * Removes as a listener from all managers
   *
   */
  public void leave() {
    OnRequestManager.instance().removeOnRequestListener(this);
    TimerRanOutManager.instance().removeTimerRanOutListener(this);
    TimerTickedManager.instance().removeTimerTickedListener(this);
  }

  /**
   * For singleton
*qaZ
   * @return the object
   */
  public static OnState instance() {
    if (instance == null) {
      instance = new OnState();
    }
    return instance;
  }

  /**
   * Process on request
   */
  public void onRequested(OnRequestEvent event) {
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
   * Initializes the state Adds itself as a listener to managers Updates the
   * dosplays
   *
   */
  public void run() {
    ParkRequestManager.instance().addVehicleParkListener(this);
    OnRequestManager.instance().addOnRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.turnVehicleOn();
    Timer.instance().setSpeed(0);
    display.displaySpeed(Timer.instance().getSpeed());
  }
}