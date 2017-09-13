package design.bridge;
/**
 *
 * @author shsharma
 */
public abstract class EntertainmentDevice {
	protected int deviceState; // current channel or chapter
	protected int maxSetting;  // max channel or chapter
	protected int volumeSetting;
	
	EntertainmentDevice(int curr, int max){
		deviceState = curr;
		maxSetting = max;
	}
	
	public abstract void deviceFeedback();
	public abstract void buttonFivePressed();
	public abstract void buttonSixPressed();
	
	public void buttonSevenPressed(){
		volumeSetting--;
	}
	
	public void buttonEightPressed(){
		volumeSetting++;
	}
}
