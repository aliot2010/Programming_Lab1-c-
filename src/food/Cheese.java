package food;

/**
 * Created by aliot on 24.09.2016.
 * конкретный класс начинки
 */
public class Cheese extends FoodDecorator  {
    Food food;

    public Cheese(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return food.getDescription()+", Cheese";
    }

    @Override
    public Food getFood() {
        return  food;
    }

    @Override
    public double colories() {
        return 150.+ food.colories();
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


        return this.food.equals(((Cheese) obj).getFood());
    }
}
