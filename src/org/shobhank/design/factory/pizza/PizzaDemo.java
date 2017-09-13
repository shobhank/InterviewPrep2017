package design.factory.pizza;
/**
 *
 * @author shsharma
 */
public class PizzaDemo {

	public static void main(String[] args) {
		PizzaStore sN = new NYPizzaStore();
		sN.orderPizza("chicken");
		
		System.out.println("\n\n\n");
		PizzaStore sC = new ChicagoPizzaStore();
		sC.orderPizza("cheese");
	}

}
