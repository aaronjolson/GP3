import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 * Class for managing the drive requests and listeners.
 */
public class DriveRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static DriveRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private DriveRequestManager() {
	}

  /**
   * for creating as a singleton.
   * @return the instance
   */
	public static DriveRequestManager instance() {
		if (instance == null) {
			instance = new DriveRequestManager();
		}
		return instance;
	}

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
	public void addDriveListener(DriveListener listener) {
		listenerList.add(DriveListener.class, listener);
	}

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
	public void removeDriveListener(DriveListener listener) {
		listenerList.remove(DriveListener.class, listener);
	}

  /**
   * For processing the drive request events
   * @param event the event that made the request
   */
	public void processEvent(DriveEvent event) {
		EventListener[] listeners = listenerList.getListeners(DriveListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((DriveListener) listeners[index]).drive(event);
		}
	}
}