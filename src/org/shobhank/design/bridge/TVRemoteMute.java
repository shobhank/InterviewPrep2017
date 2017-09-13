package design.bridge;
/**
 *
 * @author shsharma
 */

public class TVRemoteMute extends Remote{

	TVRemoteMute(EntertainmentDevice device) {
		super(device);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonNinePressed() {
		// TODO Auto-generated method stub
		System.out.println("Muted");
	}

}
