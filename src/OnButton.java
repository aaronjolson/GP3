public class OnButton extends GUIButton {
  /**
   * The button for accelerating
   *
   * @param string
   */
  public OnButton(String string) {
    super(string);
  }

  /**
   * Creates a OnRequestEvent, so the interested states can get it. Call the
   * manager, so it can forward it
   */
  public void inform(VehicleDisplay source) {
    OnRequestManager.instance().processEvent(new OnRequestEvent(source));
  }
}