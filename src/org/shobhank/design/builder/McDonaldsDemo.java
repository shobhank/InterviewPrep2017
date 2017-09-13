package design.builder;
/**
 *
 * @author shsharma
 */
public class McDonaldsDemo {
	public static void main(String as[]){
		Meal veggie = new MealBuilder().veggieMeal();
		veggie.showItems();
		System.out.println("Total price " + veggie.total());
		
		System.out.println();
		Meal nonVeg = new MealBuilder().nonVegMeal();
		nonVeg.showItems();
		System.out.println("Total price " + nonVeg.total());
	}
}
