public class OffButton extends GUIButton {
  /**
   * The button for accelerating
   * @param string the label
   */
  public OffButton(String string) {
    super(string);
  }

  /**
   * Creates an OffRequestEvent, so the interested states can get it. Call the
   * manager, so it can forward it
   */
  public void inform(VehicleDisplay source) {
    OffRequestManager.instance().processEvent(new OffRequestEvent(source));
  }
}