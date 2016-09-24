package food;

/**
 * Created by aliot on 24.09.2016.
 */
public class Tomato extends FoodDecorator {

    Food food;

    public Tomato(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return food.getDescription()+", Tomato";
    }

    @Override
    public Food getFood() {
        return  food;
    }

    @Override
    public double colories() {
        return 40.+ food.colories();
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
        Tomato other = (Tomato) obj;

        return this.food.equals(((Tomato) obj).getFood());
    }
}
