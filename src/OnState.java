/**
 * Represents the on state.
 *
 */
public class OnState extends VehicleState
    implements OnRequestListener, OffRequestListener, DriveListener {
  private static OnState instance;

  /**
   * Private for the singleton pattern
   */
  private OnState() {
    instance = this;
  }

  /**
   * Removes as a listener from all managers
   */
  public void leave() {
    OnRequestManager.instance().removeOnRequestListener(instance);
    OffRequestManager.instance().removeOffRequestListener(instance);
    DriveRequestManager.instance().removeDriveListener(instance);
  }

  /**
   * For singleton
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
    context.changeCurrentState(OnState.instance());
  }

  /**
   * Process off request
   */
  public void offRequested(OffRequestEvent event) {
    context.changeCurrentState(OffState.instance());
  }

  /**
   * Process drive request
   */
  public void drive(DriveEvent event) {
    context.changeCurrentState(DriveState.instance());
  }

  /**
   * Initializes the state Adds itself as a listener to managers.
   * Updates the displays
   */
  public void run() {
    OnRequestManager.instance().addOnRequestListener(instance);
    OffRequestManager.instance().addOffRequestListener(instance);
    DriveRequestManager.instance().addDriveListener(instance);
    display.turnVehicleOn();
    display.vehicleParked();
  }
}