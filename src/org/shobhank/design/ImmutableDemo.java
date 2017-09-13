package org.shobhank.design;

import java.util.Date;

/**
 *
 * @author shsharma
 */
public class ImmutableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello";
		Immutable i1 = Immutable.createInstance(s,new Date());
		System.out.println(i1);
		tryModification(i1.getText());
		System.out.println(i1);
	}
	
    private static void tryModification(String immutableField2)
    {
        immutableField2 = "test changed";
    }

}

final class Immutable {
	private final String text;
	private final Date date;
	
	private Immutable(String text, Date date){
		this.text = text;
		this.date = date;
	}
	
	public static Immutable createInstance(String text, Date date){
		return new Immutable(text, date);
	}

	public String getText() {
		return text;
	}
	
	public Date getDate(){
		return (Date) date.clone();
	}
	
    @Override
    public String toString() {
        return text + date;
    }
}
