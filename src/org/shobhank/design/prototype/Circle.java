package org.shobhank.design.prototype;
/**
 *
 * @author shsharma
 */
public class Circle extends Shape{
	
	Circle(){
		setType();
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle");
	}
	
	void setType(){
		this.type = "Circle";
	}

}
