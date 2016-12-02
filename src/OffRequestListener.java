import java.util.EventListener;

/**
 * OffRequestListener to process accelerate requests
 */
public interface OffRequestListener extends EventListener {
  /**
   * Processes off requests
   * @param event the event making the request
   */
  public void offRequested(OffRequestEvent event);
}