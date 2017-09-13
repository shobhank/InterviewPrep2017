package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class ChicagoPizzaStore extends PizzaStore{
	protected Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equalsIgnoreCase("cheese"))
			return new ChicagoStyleCheesePizza();
		else 
			return null;
	}
}
