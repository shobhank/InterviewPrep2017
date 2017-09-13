package org.shobhank.design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shsharma
 */
public class ShapeCache {
	public static Map<Integer, Shape> cache = new HashMap<>();
	
	public Shape getShape(int id){
		Shape s = cache.get(id);
		if(s!=null)
			return (Shape) s.clone();
		else
			return null;
	}
	
	public static void loadCache(){
		// assume that the objects are populated through db
		Circle c1 = new Circle();
		c1.setId(1);
		
		Square s1 = new Square();
		s1.setId(2);
		
		Circle c2 = new Circle();
		c2.setId(3);
		
		Square s2 = new Square();
		s2.setId(4);
		
		Circle c3 = new Circle();
		c3.setId(5);
		
		cache.put(c1.getId(), c1);
		cache.put(c2.getId(), c2);
		cache.put(c3.getId(), c3);
		cache.put(s1.getId(), s1);
		cache.put(s2.getId(), s2);
	}
}
