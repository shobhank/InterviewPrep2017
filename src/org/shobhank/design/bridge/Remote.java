package design.bridge;
/**
 *
 * @author shsharma
 */

public abstract class Remote {
	EntertainmentDevice device;
	
	Remote(EntertainmentDevice device){
		this.device = device;
	}
	
	public void buttonFivePressed(){
		device.buttonFivePressed();
	}
	
	public void buttonSixPressed(){
		device.buttonSixPressed();
	}
	
	public void buttonSevenPressed(){
		device.buttonSevenPressed();
	}
	
	public void buttonEightPressed(){
		device.buttonEightPressed();
	}
	
	public void deviceFeedback(){
		device.deviceFeedback();
	}
	
	public abstract void buttonNinePressed();
		
}
