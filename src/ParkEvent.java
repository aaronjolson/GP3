import java.util.EventObject;

/**
 * Represents the park request
 */
public class ParkEvent extends EventObject {
  /**
   * Constructor simply calls the super class's constructor with the supplied
   * source
   *
   * @param source whatever we get
   */
	public ParkEvent(Object source) {
		super(source);
	}
}