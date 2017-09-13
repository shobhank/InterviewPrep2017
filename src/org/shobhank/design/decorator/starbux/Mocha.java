package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class Mocha extends CondimentDecorator{
	
	Beverage beverage;
	Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost(){
		return beverage.cost() + .99;
	}
}
