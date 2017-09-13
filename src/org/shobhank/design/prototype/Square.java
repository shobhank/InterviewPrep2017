package org.shobhank.design.prototype;
/**
 *
 * @author shsharma
 */
public class Square extends Shape{
	
	Square(){
		setType();
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Square");
	}
	
	void setType(){
		this.type = "Square";
	}

}
