package design.decorator.starbux;
/**
 *
 * @author shsharma
 */
public class TestStarbux {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage b1 = new Espresso();
		b1 = new Mocha(b1);
		b1 = new Whip(b1);
		System.out.println(b1.getDescription() + " " + b1.cost());
		
		Beverage b2 = new HouseBlend();
		b2 = new Mocha(b2);
		b2 = new Mocha(b2);
		b2 = new Soy(b2);
		System.out.println(b2.getDescription() + " " + b2.cost());
	}

}
