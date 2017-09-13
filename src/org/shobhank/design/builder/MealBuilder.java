package design.builder;
/**
 *
 * @author shsharma
 */
public class MealBuilder {
	public Meal veggieMeal(){
		Meal meal = new Meal();
		meal.addItem(new VeggieBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	public Meal nonVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new VeggieBurger());
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
