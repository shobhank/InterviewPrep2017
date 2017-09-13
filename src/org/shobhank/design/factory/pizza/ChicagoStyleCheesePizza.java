package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class ChicagoStyleCheesePizza extends Pizza{
	public ChicagoStyleCheesePizza(){
		this.name = "Chicago Style Cheese Pizza";
		this.dough = "Thick Crust";
		this.sauce = "Plum Tomato";
		toppings.add("Olives");
	}
}
