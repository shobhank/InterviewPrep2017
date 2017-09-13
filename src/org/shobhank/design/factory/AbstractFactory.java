package org.shobhank.design.factory;
/**
 *
 * @author shsharma
 */
public abstract class AbstractFactory {
	public abstract Shape getShape(ShapeEnum s);
	public abstract Color getColor(ColorEnum c);
}
