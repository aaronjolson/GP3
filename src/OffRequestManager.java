import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class OffRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static OffRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private OffRequestManager() {
  }

  public static OffRequestManager instance() {
    if (instance == null) {
      instance = new OffRequestManager();
    }
    return instance;
  }

  public void addOffRequestListener(OffRequestListener listener) {
    listenerList.add(OffRequestListener.class, listener);
  }

  public void removeOffRequestListener(OffRequestListener listener) {
    listenerList.remove(OffRequestListener.class, listener);
  }

  public void processEvent(OffRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(OffRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((OffRequestListener) listeners[index]).offRequested(event);
    }
  }
}
