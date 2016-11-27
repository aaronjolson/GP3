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

	public void addAccelerateRequestListener(AccelerateRequestListener listener) {
		listenerList.add(AccelerateRequestListener.class, listener);
	}

	public void removeAccelerateRequestListener(AccelerateRequestListener listener) {
		listenerList.remove(AccelerateRequestListener.class, listener);
	}

	public void processEvent(AccelerateRequestEvent event) {
		EventListener[] listeners = listenerList.getListeners(AccelerateRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((AccelerateRequestListener) listeners[index]).accelerateRequested(event);
		}
	}
}
