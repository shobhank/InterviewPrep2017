package org.shobhank.design.prototype;
/**
 *
 * @author shsharma
 */
public class PrototypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeCache.loadCache();
		
		ShapeCache sc = new ShapeCache();
		Shape s = sc.getShape(3);
		System.out.println(s.getId() + " " + s.getType());
	}

}
