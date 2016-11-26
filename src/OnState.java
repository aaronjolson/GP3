/**
 * Represents the on state.
 *
 */
public class OnState extends VehicleState
    implements OnRequestListener, TimerRanOutListener, TimerTickedListener, VehicleParkListener {
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
    OnRequestManager.instance().addOnRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.turnLightOn();
    Timer.instance().setTimeValue(0);
    display.displayTimeRemaining(Timer.instance().getTimeValue());
  }
}