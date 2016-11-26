import java.util.EventListener;
import javax.swing.event.EventListenerList;

public class OnRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static OnRequestManager instance;

  private OnRequestManager() {
  }

  public static OnRequestManager instance() {
    if (instance == null) {
      instance = new OnRequestManager();
    }
    return instance;
  }

  public void addOnRequestListener(OnRequestListener listener) {
    listenerList.add(OnRequestListener.class, listener);
  }

  public void removeOnRequestListener(OnRequestListener listener) {
    listenerList.remove(OnRequestListener.class, listener);
  }

  public void processEvent(OnRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(OnRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((OnRequestListener) listeners[index]).onRequested(event);
    }
  }
}
