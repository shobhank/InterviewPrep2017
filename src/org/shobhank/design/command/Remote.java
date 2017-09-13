package design.command;
/**
 *
 * @author shsharma
 */
public class Remote {
	Command command;
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void buttonPress(){
		command.execute();
	}
}
