import java.util.EventObject;

/**
 * Represents the accelerate request
 *
 */
public class AccelerateRequestEvent extends EventObject {
	/**
	 * Constructor simply calls the super class's constructor with the supplied
	 * source
	 * 
	 * @param source whatever we get
	 */
	public AccelerateRequestEvent(Object source) {
		super(source);
	}
}