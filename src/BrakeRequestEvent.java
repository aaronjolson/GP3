import java.util.EventObject;

/**
 * Represents the brake request
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

