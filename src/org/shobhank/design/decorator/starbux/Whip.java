package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class Whip extends CondimentDecorator{
	
	Beverage  beverage;
	
	Whip(Beverage beverage){
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
