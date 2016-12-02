import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 * Class for managing the on requests and listeners.
 */
public class OnRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static OnRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private OnRequestManager() {
  }

  /**
   * for creating as a singleton.
   * @return the instance
   */
  public static OnRequestManager instance() {
    if (instance == null) {
      instance = new OnRequestManager();
    }
    return instance;
  }

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
  public void addOnRequestListener(OnRequestListener listener) {
    listenerList.add(OnRequestListener.class, listener);
  }

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
  public void removeOnRequestListener(OnRequestListener listener) {
    listenerList.remove(OnRequestListener.class, listener);
  }

  /**
   * For processing the on request events
   * @param event the event that made the request
   */
  public void processEvent(OnRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(OnRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((OnRequestListener) listeners[index]).onRequested(event);
    }
  }
}
