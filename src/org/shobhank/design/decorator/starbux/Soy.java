package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class Soy extends CondimentDecorator{
	Beverage  beverage;
	
	Soy(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Whipped Cream";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .5;
	}
}
