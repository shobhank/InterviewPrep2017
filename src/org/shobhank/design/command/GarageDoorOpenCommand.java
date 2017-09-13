package design.command;
/**
 *
 * @author shsharma
 */
public class GarageDoorOpenCommand implements Command{
	GarrageDoor gDoor;
	
	GarageDoorOpenCommand(GarrageDoor gDoor){
		this.gDoor = gDoor;
	}
	
	@Override
	public void execute() {
		gDoor.up();
	}

}
