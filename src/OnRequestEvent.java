import java.util.EventObject;

/**
 * Represents the on request
 */
public class OnRequestEvent extends EventObject {
  /**
   * Constructor simply calls the super class's constructor with the supplied
   * source
   *
   * @param source whatever we get
   */
  public OnRequestEvent(Object source) {
    super(source);
  }
}