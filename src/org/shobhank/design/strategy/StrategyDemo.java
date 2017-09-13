package design.strategy;
/**
 *
 * @author shsharma
 */
public class StrategyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context ctx = new Context(new AddStrategy());
		System.out.println(ctx.execute(4, 5));
	}

}
