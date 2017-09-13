package design.observer;
/**
 *
 * @author shsharma
 */
public class CurrentConditionsDisplay implements Observer, Display{
	private double temperature;
	private double humidity;
	private double pressure;
	private Subject subject;
	
	CurrentConditionsDisplay(Subject subject){
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(double temp, double humidity, double pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Temperature is " + temperature + "\nHumidity is " + humidity
				+ "\nPressure is " + pressure);
	}
	
	

}
