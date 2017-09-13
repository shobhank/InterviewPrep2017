package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public abstract class Beverage {
	
	String description = "unknown";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}
