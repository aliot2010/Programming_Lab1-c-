package food;

/**
 * Created by aliot on 24.09.2016.
 */
public class Meat extends FoodDecorator {
    Food food;

    public Meat(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return food.getDescription()+", Meat";
    }

    @Override
    public Food getFood() {
        return  food;
    }

    @Override
    public double colories() {
        return 180.+ food.colories();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }if(obj==null){
            return false;
        }if (getClass() != obj.getClass()) {
            return false;
        }


        return this.food.equals(((Meat) obj).getFood());
    }
}
