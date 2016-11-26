import java.util.EventListener;

/**
 * Any class may be an BrakeRequestListener to process accelerate requests
 *
 * @author Aaron Olson
 *
 */
public interface BrakeRequestListener extends EventListener {
  /**
   * Processes brake requests
   *
   * @param event
   */
  public void brakeRequested(BrakeRequestEvent event);
}