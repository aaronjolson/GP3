
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
import java.util.Observable;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public abstract class VehicleDisplay extends Observable {
	protected static VehicleContext context;
	protected static VehicleDisplay instance;

	/**
	 * Initializes the context and instance
	 */
	protected VehicleDisplay() {
		instance = this;
		context = VehicleContext.instance();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static VehicleDisplay instance() {
		return instance;
	}

	/**
	 * Do the initializations to make the context an observer
	 */
	public void initialize() {
		context.initialize();
	}

  /**
   * Indicate that the vehicle's current speed
   */
	public abstract void displaySpeed(int speed);

	/**
	 * Indicate that the vehicle is on
	 */
	public abstract void turnVehicleOn();

	/**
	 * Indicate that the vehicle is off
	 */
	public abstract void turnVehicleOff();

	/**
	 * Indicate that the vehicle is in drive
	 */
	public abstract void driveVehicle();

	/**
	 * Indicate that the vehicle now parked
	 */
	public abstract void vehicleParked();

	/**
	 * indicate that accelerating has begun
	 */
	public abstract void startAccelerating();

  /**
   * indicate that braking has begun
   */
  public abstract void startBraking();
}