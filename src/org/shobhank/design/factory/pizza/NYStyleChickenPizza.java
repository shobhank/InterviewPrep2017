package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class NYStyleChickenPizza extends Pizza{
	
	public NYStyleChickenPizza(){
		this.name = "NY Style Chicken Pizza";
		this.dough = "Thin Crust";
		this.sauce = "Marinara";
		toppings.add("Chicken");
	}
}
