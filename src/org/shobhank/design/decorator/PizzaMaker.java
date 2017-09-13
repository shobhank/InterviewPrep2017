package design.decorator;
/**
 *
 * @author shsharma
 */
public class PizzaMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza = new Olives(new Mozarella(new BasicPizza()));
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}

}
