/**
 * Represents the off state.
 *
 */
public class OffState extends VehicleState
    implements OffRequestListener, OnRequestListener, ParkListener {
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
    OffRequestManager.instance().removeOffRequestListener(instance);
    OnRequestManager.instance().removeOnRequestListener(instance);
    ParkRequestManager.instance().removeParkListener(instance);
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
    context.changeCurrentState(OffState.instance());
  }

  /**
   * Process on request
   */
  public void onRequested(OnRequestEvent event) {
    context.changeCurrentState(OnState.instance());
  }

  /**
   * Process park request
   */
  public void vehicleParked(ParkEvent event) {
    context.changeCurrentState(ParkState.instance());
  }

  /**
   * Initializes the state Adds itself as a listener to managers.
   * Updates the displays.
   */
  public void run() {
    ParkRequestManager.instance().addParkListener(instance);
    OffRequestManager.instance().addOffRequestListener(instance);
    OnRequestManager.instance().addOnRequestListener(instance);
    display.turnVehicleOff();
    display.displaySpeed(0);
  }
}