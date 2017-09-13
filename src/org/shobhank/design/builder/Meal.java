package design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shsharma
 */
public class Meal {
	private List<Item> list = new ArrayList<>();
	
	public void addItem(Item item){
		list.add(item);
	}
	
	public float total(){
		float total = 0.0f;
		for(Item item:list){
			total = total + item.getPrice();
		}
		return total;
	}
	
	public void showItems(){
		for(Item item:list){
			System.out.print(item.getName() + " " + item.getPrice() + " ");
			item.getPacking().pack();
		}
	}
}
