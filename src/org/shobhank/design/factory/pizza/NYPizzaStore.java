package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class NYPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("cheese"))
			return new NYStyleCheesePizza();
		else if(type.equalsIgnoreCase("chicken"))
			return new NYStyleChickenPizza();
		else 
			return null;
	}

}
