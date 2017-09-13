package design.builder;
/**
 *
 * @author shsharma
 */
public abstract class Burger implements Item{

	@Override
	public Packaging getPacking() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

}
