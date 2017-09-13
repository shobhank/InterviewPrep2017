package design.observer;

/**
 * @author shsharma
 *
 */
public interface Observer {
	
	public void update(double temp, double humidity, double pressure);
}
