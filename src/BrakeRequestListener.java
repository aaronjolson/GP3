import java.util.EventListener;

/**
 * BrakeRequestListener to process accelerate requests
 */
public interface BrakeRequestListener extends EventListener {
  /**
   * Processes brake requests
   * @param event the event that requested
   */
  public void brakeRequested(BrakeRequestEvent event);
}