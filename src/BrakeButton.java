/**
 * Created by Aaron on 11/25/16.
 */
public class BrakeButton extends GUIButton {
    /**
     * The button for braking
     *
     * @param string
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

