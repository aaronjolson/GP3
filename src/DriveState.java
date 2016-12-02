/**
 * Represents the drive state
 */
public class DriveState extends VehicleState implements AccelerateRequestListener, BrakeRequestListener, ParkListener {
	private static DriveState instance;

  /**
   * Private for the singleton pattern
   */
  private DriveState() {
		instance = this;
	}

  /**
   * Removes as a listener from all managers
   */
	public void leave() {
    AccelerateRequestManager.instance().removeAccelerateRequestListener(instance);
    ParkRequestManager.instance().removeParkListener(instance);
    BrakeRequestManager.instance().removeBrakeRequestListener(instance);
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static DriveState instance() {
		if (instance == null) {
			instance = new DriveState();
		}
		return instance;
	}

	/**
	 * handle park event
	 */
	@Override
	public void vehicleParked(ParkEvent event) {
		context.changeCurrentState(ParkState.instance());
	}

	/**
	 * handle accelerate request
	 */
	@Override
	public void accelerateRequested(AccelerateRequestEvent event) {
		context.changeCurrentState(AcceleratingState.instance());
	}

  /**
   * handle brake request
   */
  @Override
  public void brakeRequested(BrakeRequestEvent event) {
    context.changeCurrentState(BrakingState.instance());
  }

	/**
	 * initialize the state
	 */
	public void run() {
    AccelerateRequestManager.instance().addAccelerateRequestListener(instance);
    BrakeRequestManager.instance().addBrakeRequestListener(instance);
    ParkRequestManager.instance().addParkListener(instance);
		display.driveVehicle();
		display.displaySpeed(0);
		Timer.instance().setSpeed(0);
	}
}