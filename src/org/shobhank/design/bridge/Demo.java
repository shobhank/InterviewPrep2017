package design.bridge;
/**
 *
 * @author shsharma
 */
public class Demo {
	public static void main(String as[]){
		Remote r1 = new TVRemoteMute(new TVDevice(1,5));
		r1.deviceFeedback();
		r1.buttonFivePressed();
		r1.deviceFeedback();
		r1.buttonNinePressed();
		r1.buttonSevenPressed();
		r1.buttonSevenPressed();
		r1.deviceFeedback();
	}
}
