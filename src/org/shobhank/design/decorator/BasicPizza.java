package design.decorator;
/**
 *
 * @author shsharma
 */
public class BasicPizza implements Pizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Dough, Cheese, Spices";
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return 5.99f;
	}

}
