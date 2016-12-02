import java.util.EventListener;

/**
 * ParkListener to process park requests
 */
public interface ParkListener extends EventListener {
  /**
   * Processes on requests
   *
   * @param event whatever we get
   */
	public void vehicleParked(ParkEvent event);
}