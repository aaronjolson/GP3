/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
/**
 * The button that represents park
 *
 */
public class ParkButton extends GUIButton {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string the text to be put on the button
	 */
	public ParkButton(String string) {
		super(string);
	}

	/**
	 * Create the ParkEvent and tell the manager that the button has been
	 * clicked.
	 */
	public void inform(VehicleDisplay source) {
    ParkRequestManager.instance().processEvent(new ParkEvent(source));
	}
}