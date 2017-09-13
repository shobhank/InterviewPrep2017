package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public class ColorFactory extends AbstractFactory{
	
	@Override
	public Color getColor(ColorEnum c){
		switch(c){
		case RED: 
			return new Red();
		case BLUE:
			return new Blue();
		default:
			return null;
		}
	}

	@Override
	public Shape getShape(ShapeEnum s) {
		// TODO Auto-generated method stub
		return null;
	}
}
