import java.util.EventListener;

/**
 * DriveListener class to process drive requests
 */
public interface DriveListener extends EventListener {
	public void drive(DriveEvent event);
}