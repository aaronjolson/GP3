import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 * Class for managing the acceleration requests and listeners.
 */
public class AccelerateRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static AccelerateRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private AccelerateRequestManager() {
  }

  /**
   * for creating as a singleton.
   * @return the instance
   */
  public static AccelerateRequestManager instance() {
		if (instance == null) {
			instance = new AccelerateRequestManager();
		}
		return instance;
	}

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
	public void addAccelerateRequestListener(AccelerateRequestListener listener) {
		listenerList.add(AccelerateRequestListener.class, listener);
	}

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
	public void removeAccelerateRequestListener(AccelerateRequestListener listener) {
		listenerList.remove(AccelerateRequestListener.class, listener);
	}

  /**
   * For handling the accelerate request events
   * @param event the event that made the request
   */
	public void processEvent(AccelerateRequestEvent event) {
		EventListener[] listeners = listenerList.getListeners(AccelerateRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((AccelerateRequestListener) listeners[index]).accelerateRequested(event);
		}
	}
}
