package food;

/**
 * Created by aliot on 24.09.2016.
 */
public class Tomato extends FoodDecorator {

    Food food;


    public Tomato(){
        this.food = null;
        description = "Tomato";
        colories = 40.;
    }
    public Tomato(Food food) {
        this.food = food;
        description = "Tomato";
        colories = 40.;
    }

    @Override
    public String getDescription() {
        if(this.food!=null)
            return food.getDescription()+", "+this.description;
        else
            return description;

    }

    @Override
    public Food getFood() {
        return  food;
    }

    @Override
    public double colories() {
        if(this.food!=null)
            return this.colories+ food.colories();
        else
            return this.colories;
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


        return this.food.equals(((Tomato) obj).getFood());
    }
}
