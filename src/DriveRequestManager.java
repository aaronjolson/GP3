import java.util.EventListener;
import javax.swing.event.EventListenerList;

/**
 *
 */
public class DriveRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static DriveRequestManager instance;

  /**
   *  Private constructor to keep the class private
   */
  private DriveRequestManager() {
	}

	public static DriveRequestManager instance() {
		if (instance == null) {
			instance = new DriveRequestManager();
		}
		return instance;
	}

	public void addDriveListener(DriveListener listener) {
		listenerList.add(DriveListener.class, listener);
	}

	public void removeDriveVehicleListener(DriveListener listener) {
		listenerList.remove(DriveListener.class, listener);
	}

	public void processEvent(DriveEvent event) {
		EventListener[] listeners = listenerList.getListeners(DriveListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((DriveListener) listeners[index]).drive(event);
		}
	}
}