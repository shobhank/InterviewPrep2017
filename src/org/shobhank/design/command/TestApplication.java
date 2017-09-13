package design.command;
/**
 *
 * @author shsharma
 */
public class TestApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remote remote = new Remote();
		Light light = new Light();
		Command lightOn = new LightOnCommand(light);
		remote.setCommand(lightOn);
		remote.buttonPress();
		
		Command lightOff = new LightOffCommand(light);
		remote.setCommand(lightOff);
		remote.buttonPress();
		
		
		GarrageDoor  gDoor = new GarrageDoor();
		Command gOpen = new GarageDoorOpenCommand(gDoor); 
		remote.setCommand(gOpen);
		remote.buttonPress();
		
		Command gClose = new GarageDoorCloseCommand(gDoor); 
		remote.setCommand(gClose);
		remote.buttonPress();
		
	}

}
