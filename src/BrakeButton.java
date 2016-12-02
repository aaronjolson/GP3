/**
 * GUIButton subclass to handle engaging braking.
 */
public class BrakeButton extends GUIButton {
    /**
     * The button for braking
     * @param string the label
     */
    public BrakeButton(String string) {
      super(string);
    }

    /**
     * Creates a AccelerateRequestEvent, so the interested states can get it. Call the
     * manager, so it can forward it
     */
    public void inform(VehicleDisplay source) {
      BrakeRequestManager.instance().processEvent(new BrakeRequestEvent(source));
    }
}

