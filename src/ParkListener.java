import java.util.EventListener;

/**
 * ParkListener to process park requests
 */
public interface ParkListener extends EventListener {
  /**
   * Processes park requests
   *
   * @param event whatever we get
   */
	public void vehicleParked(ParkEvent event);
}