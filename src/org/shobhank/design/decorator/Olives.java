package design.decorator;
/**
 *
 * @author shsharma
 */
public class Olives extends PizzaDecorator{

	Olives(Pizza newPizza) {
		super(newPizza);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Olives";
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 1.5f;
	}

}
