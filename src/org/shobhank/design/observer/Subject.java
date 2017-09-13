package design.observer;
/**
 *
 * @author shsharma
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void unRegisterObserver(Observer o);
	public void notifyObservers();
}
