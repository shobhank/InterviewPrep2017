package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public abstract class PizzaStore {
	
	public Pizza orderPizza(String type){
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
	}
	
	protected abstract Pizza createPizza(String type); 
}
