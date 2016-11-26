public class OffButton extends GUIButton {
  /**
   * The button for accelerating
   *
   * @param string
   */
  public OffButton(String string) {
    super(string);
  }

  /**
   * Creates a OffRequestEvent, so the interested states can get it. Call the
   * manager, so it can forward it
   */
  public void inform(VehicleDisplay source) {
    OffRequestManager.instance().processEvent(new OffRequestEvent(source));
  }
}