package food;

/**
 * Created by aliot on 24.09.2016.
 * конкретный класс начинки
 */
public class Cheese extends FoodDecorator  {
    Food food;


    public Cheese (){
        this.food = null;
        this.description = "Cheese";
        colories = 150.;
    }
    public Cheese(Food food) {
        this.food = food;
        this.description = "Cheese";
        colories = 150.;
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


        return this.food.equals(((Cheese) obj).getFood());
    }
}
