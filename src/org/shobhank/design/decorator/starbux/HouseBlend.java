package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class HouseBlend extends Beverage{
	
	HouseBlend(){
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
