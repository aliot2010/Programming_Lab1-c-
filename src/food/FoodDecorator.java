package food;

/**
 * Created by aliot on 24.09.2016.
 * Абстрактный класс для начинки
 */
public abstract class FoodDecorator extends Food {
    Food food;
    double colories = 0;

    public abstract String getDescription();

    public abstract Food getFood();


    public double colories() {
        return this.colories+food.colories();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
