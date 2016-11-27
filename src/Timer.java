
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
import java.util.Observable;
import java.util.Observer;

public class Timer implements Observer {
	private static Timer instance;
	private int speed;
  private boolean accelerating;

	private Timer() {
		instance = this;
		Clock.instance().addObserver(instance);
	}

	public static Timer instance() {
		if (instance == null) {
			instance = new Timer();
		}
		return instance;
	}

	public void setSpeed(int value) {
		this.speed = value;
	}

	public void addSpeed(int value) {
		speed += value;
	}

	public int getSpeed() {
		return speed;
	}

	public void setAccelerating(boolean state) {
    this.accelerating = state;
  }

  public boolean getAccelerating() {
    return accelerating;
  }

	@Override
	public void update(Observable clock, Object value) {
    if (getAccelerating()) {
      speed += 5;
    } else {
      speed -= 5;
    }
    if (speed >= 50) {
      speed = 50;
    }
    if (speed <= 0) {
      speed = 0;
    }
    if (speed == 0) {
			TimerRanOutManager.instance().processEvent(new TimerRanOutEvent(instance));
		} else {
			TimerTickedManager.instance().processEvent(new TimerTickedEvent(instance));
		}

	}
}