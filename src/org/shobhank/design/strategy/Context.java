package design.strategy;
/**
 *
 * @author shsharma
 */
public class Context {
	private Strategy strategy;

	Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public int execute(int a,int b){
		return strategy.doOperation(a, b);
	}
	
}
