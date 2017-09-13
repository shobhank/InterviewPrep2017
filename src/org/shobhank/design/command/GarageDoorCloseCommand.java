package design.command;
/**
 *
 * @author shsharma
 */
public class GarageDoorCloseCommand implements Command{
	GarrageDoor gDoor;
	
	GarageDoorCloseCommand(GarrageDoor gDoor){
		this.gDoor = gDoor;
	}
	
	@Override
	public void execute() {
		gDoor.down();
	}
}
