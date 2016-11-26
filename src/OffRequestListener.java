import java.util.EventListener;

/**
 * Any class may be an OffRequestListener to process accelerate requests
 *
 * @author Aaron Olson
 *
 */
public interface OffRequestListener extends EventListener {
  /**
   * Processes off requests
   *
   * @param event
   */
  public void offRequested(OffRequestEvent event);
}