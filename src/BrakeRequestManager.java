import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class BrakeRequestManager {
  private EventListenerList listenerList = new EventListenerList();
  private static BrakeRequestManager instance;

  private BrakeRequestManager() {
  }

  public static BrakeRequestManager instance() {
    if (instance == null) {
      instance = new BrakeRequestManager();
    }
    return instance;
  }

  public void addBrakeRequestListener(BrakeRequestListener listener) {
    listenerList.add(BrakeRequestListener.class, listener);
  }

  public void removeBrakeRequestListener(BrakeRequestListener listener) {
    listenerList.remove(BrakeRequestListener.class, listener);
  }

  public void processEvent(BrakeRequestEvent event) {
    EventListener[] listeners = listenerList.getListeners(BrakeRequestListener.class);
    for (int index = 0; index < listeners.length; index++) {
      ((BrakeRequestListener) listeners[index]).brakeRequested(event);
    }
  }
}
