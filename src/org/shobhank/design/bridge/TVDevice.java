package design.bridge;
/**
 *
 * @author shsharma
 */
public class TVDevice extends EntertainmentDevice{

	TVDevice(int curr, int max) {
		super(curr, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deviceFeedback() {
		// TODO Auto-generated method stub
		System.out.println("TV Device: Channel " + deviceState + " Volume: " + volumeSetting);
	}

	@Override
	public void buttonFivePressed() {
		// TODO Auto-generated method stub
		System.out.println("Channel Down");
		if(deviceState > 0)
			deviceState--;
		else
			deviceState = 0;
	}

	@Override
	public void buttonSixPressed() {
		// TODO Auto-generated method stub
		System.out.println("Channel Up");
		if(deviceState < maxSetting)
			deviceState++;
		else
			deviceState = maxSetting;
	}

}
