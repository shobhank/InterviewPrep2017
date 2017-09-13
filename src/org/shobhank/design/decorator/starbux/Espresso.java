package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class Espresso extends Beverage{
	
	Espresso(){
		description = "Espresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 2.99;
	}

}
