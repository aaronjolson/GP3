/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * Represents the parked state
 */
public class ParkState extends VehicleState implements ParkListener, DriveListener, OffRequestListener {
	private static ParkState instance;

  /**
   * Private for the singleton pattern
   */
  private ParkState() {
		instance = this;
	}

  /**
   * Removes as a listener from all managers
   */
	public void leave() {
    ParkRequestManager.instance().removeParkListener(instance);
    DriveRequestManager.instance().removeDriveListener(instance);
    OffRequestManager.instance().removeOffRequestListener(instance);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static ParkState instance() {
		if (instance == null) {
			instance = new ParkState();
		}
		return instance;
	}

  /**
   * Process drive event
   */
  @Override
  public void drive(DriveEvent event) {
    context.changeCurrentState(DriveState.instance());
  }

  /**
   * Process park event
   */
  @Override
  public void vehicleParked(ParkEvent event) {
    context.changeCurrentState(ParkState.instance());
  }

  /**
   * Process off event
   */
	@Override
  public void offRequested(OffRequestEvent event) {
    context.changeCurrentState(OffState.instance());
  }

	/**
	 * Initialize the state
	 */
	public void run() {
    ParkRequestManager.instance().addParkListener(instance);
    DriveRequestManager.instance().addDriveListener(instance);
    OffRequestManager.instance().addOffRequestListener(instance);
		display.vehicleParked();
	}
}