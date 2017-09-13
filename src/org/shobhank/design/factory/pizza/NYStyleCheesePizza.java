package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class NYStyleCheesePizza extends Pizza{
	public NYStyleCheesePizza(){
		this.name = "NY Style Cheese Pizza";
		this.dough = "Thin Crust";
		this.sauce = "Marinara";
		toppings.add("Mozarella");
	}
}
