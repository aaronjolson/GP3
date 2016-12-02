import java.util.EventListener;

/**
 * OnRequestListener to process on requests
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