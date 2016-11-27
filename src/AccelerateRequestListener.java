import java.util.EventListener;

/**
 * AccelerateRequestListener class to process accelerate requests
 */
public interface AccelerateRequestListener extends EventListener {
	/**
	 * Processes accelerate requests
	 * @param event the event for accelerate requests.
	 */
	public void accelerateRequested(AccelerateRequestEvent event);
}
