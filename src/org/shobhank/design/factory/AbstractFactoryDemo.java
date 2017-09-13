package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory sfactory = new FactoryProducer().getFactory(FactoryEnum.SHAPE);
		sfactory.getShape(ShapeEnum.RECTANGLE).draw();
		
		AbstractFactory cfactory = new FactoryProducer().getFactory(FactoryEnum.COLOR);
		cfactory.getColor(ColorEnum.BLUE).fill();;

	}

}
