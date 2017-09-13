package design.bridge;
/**
 *
 * @author shsharma
 */
public class DVDDevice extends EntertainmentDevice{
	
	DVDDevice(int curr, int max) {
		super(curr, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deviceFeedback() {
		// TODO Auto-generated method stub
		System.out.println("DVD Device: Chapter " + deviceState + " Volume: " + volumeSetting);
	}

	@Override
	public void buttonFivePressed() {
		// TODO Auto-generated method stub
		System.out.println("Chapter Down");
		if(deviceState > 0)
			deviceState--;
		else
			deviceState = 0;
	}

	@Override
	public void buttonSixPressed() {
		// TODO Auto-generated method stub
		System.out.println("Chapter Up");
		if(deviceState < maxSetting)
			deviceState++;
		else
			deviceState = maxSetting;
	}

}
