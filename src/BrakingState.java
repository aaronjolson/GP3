/**
 * Represents the braking state.
 *
 */
public class BrakingState extends VehicleState
    implements BrakeRequestListener, TimerRanOutListener, TimerTickedListener, ParkListener, AccelerateRequestListener {
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
    display.displaySpeed(Timer.instance().getSpeed());
  }

  @Override
  public void accelerateRequested(AccelerateRequestEvent event) {
    context.changeCurrentState(AcceleratingState.instance());
  }

  /**
   * Process park vehicle request
   */
  public void vehicleParked(ParkEvent event) {
    if (Timer.instance().getSpeed() == 0) {
      context.changeCurrentState(ParkState.instance());
    }
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
  }

  /**
   * Initializes the state Adds itself as a listener to managers. Updates the
   * displays
   *
   */
  public void run() {
    ParkRequestManager.instance().addVehicleParkListener(this);
    AccelerateRequestManager.instance().addAccelerateRequestListener(this);
    BrakeRequestManager.instance().addBrakeRequestListener(this);
    TimerRanOutManager.instance().addTimerRanOutListener(this);
    TimerTickedManager.instance().addTimerTickedListener(this);
    display.startBraking();
    Timer.instance().setAccelerating(false);
    display.displaySpeed(Timer.instance().getSpeed());
  }
}