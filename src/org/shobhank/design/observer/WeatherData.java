package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shsharma
 */
public class WeatherData implements Subject{
	
	List<Observer> observers;
	
	double temperature;
	double humidity;
	double pressure;
	
	WeatherData(){
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void unRegisterObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if(i!=-1)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o: observers){
			o.update(temperature, humidity, pressure);
		}
	}
	
	public void setMeasurements(double temperature, double humidity, double pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObservers();
	}
	

}
