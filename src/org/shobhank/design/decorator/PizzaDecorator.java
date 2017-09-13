package design.decorator;
/**
 *
 * @author shsharma
 */
public abstract class PizzaDecorator implements Pizza{
	
	Pizza pizza;
	
	PizzaDecorator(Pizza newPizza){
		pizza = newPizza;
	}


}
