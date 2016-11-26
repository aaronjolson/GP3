import java.util.EventObject;

/**
 * Represents the accelerate request
 *
 */
public class OffRequestEvent extends EventObject {
  /**
   * Constructor simply calls the super class's constructor with the supplied
   * source
   *
   * @param source whatever we get
   */
  public OffRequestEvent(Object source) {
    super(source);
  }
}