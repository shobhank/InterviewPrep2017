package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public class ShapeFactory extends AbstractFactory{
	
	@Override
	public Shape getShape(ShapeEnum s){
		switch(s){
		case CIRCLE:
			return new Circle();
		case SQUARE:
			return new Square();
		case RECTANGLE:
			return new Rectangle();
		default:
			return null;
		}
	}

	@Override
	public Color getColor(ColorEnum c) {
		// TODO Auto-generated method stub
		return null;
	}
}
