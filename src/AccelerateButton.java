/**
 * GUIButton subclass to handle engaging acceleration.
 */
public class AccelerateButton extends GUIButton {

  /**
	 * The button for accelerating
	 * @param string the label
	 */
	public AccelerateButton(String string) {
		super(string);
	}

	/**
	 * Creates an AccelerateRequestEvent, so the interested states can get it.
   * Calls the manager, so it can forward it
	 */
	public void inform(VehicleDisplay source) {
    AccelerateRequestManager.instance().processEvent(new AccelerateRequestEvent(source));
	}
}