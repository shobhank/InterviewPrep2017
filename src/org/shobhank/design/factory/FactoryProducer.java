package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public class FactoryProducer {
	public AbstractFactory getFactory(FactoryEnum f){
		switch(f){
		case SHAPE:
			return new ShapeFactory();
		case COLOR:
			return new ColorFactory();
		default:
			return null;
		}
	}
}
