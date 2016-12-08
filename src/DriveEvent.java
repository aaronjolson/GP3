import java.util.EventObject;

/**
 * Represents the drive request event
 */
public class DriveEvent extends EventObject {
  /**
   * Constructor simply calls the super class's constructor with the supplied
   * source
   *
   * @param source whatever we get
   */
	public DriveEvent(Object source) {
		super(source);
	}
}