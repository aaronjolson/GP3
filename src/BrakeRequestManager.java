import java.util.EventListener;
import javax.swing.event.EventListenerList;


public class BrakeRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static BrakeRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private BrakeRequestManager() {
  }

  /**
   * for creating as a singleton.
   * @return the instance
   */
  public static BrakeRequestManager instance() {
    if (instance == null) {
      instance = new BrakeRequestManager();
    }
    return instance;
  }

  /**
   * For adding the listener when states change
   * @param listener the listener to change
   */
  public void addBrakeRequestListener(BrakeRequestListener listener) {
    listenerList.add(BrakeRequestListener.class, listener);
  }

  /**
   * For removing the listener when states change
   * @param listener the listener to change
   */
  public void removeBrakeRequestListener(BrakeRequestListener listener) {
    listenerList.remove(BrakeRequestListener.class, listener);
  }

  /**
   * For processing the brake request events
   * @param event the event that made the request
   */
  public void processEvent(BrakeRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(BrakeRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((BrakeRequestListener) listeners[index]).brakeRequested(event);
    }
  }
}
