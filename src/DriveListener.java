import java.util.EventListener;

/**
 * DriveListener class to process drive requests
 */
public interface DriveListener extends EventListener {
  /**
   * Processes drive requests
   * @param event the event for drive requests.
   */
	public void drive(DriveEvent event);
}