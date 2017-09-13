package design.builder;
/**
 *
 * @author shsharma
 */
public abstract class Drink implements Item{

	@Override
	public Packaging getPacking() {
		// TODO Auto-generated method stub
		return new Bottle();
	}

}
