package design.strategy;
/**
 *
 * @author shsharma
 */
public class SubtractStrategy implements Strategy{

	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return Math.abs(a-b);
	}

}
