import java.util.EventListener;

/**
 * Any class may be an OnRequestListener to process on requests
 *
 * @author Aaron Olson
 *
 */
public interface OnRequestListener extends EventListener {
  /**
   * Processes on requests
   *
   * @param event
   */
  public void onRequested(OnRequestEvent event);
}