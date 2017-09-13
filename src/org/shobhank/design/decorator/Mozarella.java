package design.decorator;
/**
 *
 * @author shsharma
 */
public class Mozarella extends PizzaDecorator{

	Mozarella(Pizza newPizza) {
		super(newPizza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pizza.getDescription() + ", Mozarella";
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return pizza.getCost() + 2.5f;
	}
	
}
