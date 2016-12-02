import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 * Class for managing the drive requests and listeners.
 */
public class ParkRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static ParkRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
	private ParkRequestManager() {
	}

  /**
   * for creating as a singleton.
   * @return the instance
   */
	public static ParkRequestManager instance() {
		if (instance == null) {
			instance = new ParkRequestManager();
		}
		return instance;
	}

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
	public void addParkListener(ParkListener listener) {
		listenerList.add(ParkListener.class, listener);
	}

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
	public void removeParkListener(ParkListener listener) {
		listenerList.remove(ParkListener.class, listener);
	}

  /**
   * For processing the park request events
   * @param event the event that made the request
   */
	public void processEvent(ParkEvent event) {
		EventListener[] listeners = listenerList.getListeners(ParkListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((ParkListener) listeners[index]).vehicleParked(event);
		}
	}
}
