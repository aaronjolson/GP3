import java.util.EventObject;

/**
 * Created by agosto on 11/25/16.
 *
 * Represents the accelerate request
 *
 */
public class BrakeRequestEvent extends EventObject {

    /**
     * Constructor simply calls the super class's constructor with the supplied
     * source
     *
     * @param source whatever we get
     */
    public BrakeRequestEvent(Object source) {
      super(source);
    }
}

