import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 * Class for managing the off requests and listeners.
 */
public class OffRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static OffRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private OffRequestManager() {
  }

  /**
   * for creating as a singleton.
   * @return the instance
   */
  public static OffRequestManager instance() {
    if (instance == null) {
      instance = new OffRequestManager();
    }
    return instance;
  }

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
  public void addOffRequestListener(OffRequestListener listener) {
    listenerList.add(OffRequestListener.class, listener);
  }

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
  public void removeOffRequestListener(OffRequestListener listener) {
    listenerList.remove(OffRequestListener.class, listener);
  }

  /**
   * For processing the off request events
   * @param event the event that made the request
   */
  public void processEvent(OffRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(OffRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((OffRequestListener) listeners[index]).offRequested(event);
    }
  }
}
