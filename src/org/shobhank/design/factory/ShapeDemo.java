package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public class ShapeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		new ShapeFactory().getShape(ShapeEnum.SQUARE).draw();
	}

}
