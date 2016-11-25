
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class DriveVehicleManager {
	private EventListenerList listenerList = new EventListenerList();
	private static DriveVehicleManager instance;

	private DriveVehicleManager() {
	}

	public static DriveVehicleManager instance() {
		if (instance == null) {
			instance = new DriveVehicleManager();
		}
		return instance;
	}

	public void addDriveVehicleListener(DriveVehicleListener listener) {
		listenerList.add(DriveVehicleListener.class, listener);
	}

	public void removeDriveVehicleListener(DriveVehicleListener listener) {
		listenerList.remove(DriveVehicleListener.class, listener);
	}

	public void processEvent(DriveVehicleEvent event) {
		EventListener[] listeners = listenerList.getListeners(DriveVehicleListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((DriveVehicleListener) listeners[index]).driveVehicle(event);
		}
	}
}