import java.util.EventListener;

/**
 * OnRequestListener to process on requests
 */
public interface OnRequestListener extends EventListener {
  /**
   * Processes on requests
   *
   * @param event whatever we get
   */
  public void onRequested(OnRequestEvent event);
}