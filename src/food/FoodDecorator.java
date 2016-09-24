package food;

/**
 * Created by aliot on 24.09.2016.
 * Абстрактный класс для начинки
 */
public abstract class FoodDecorator extends Food {
    public abstract String getDescription();
    public abstract Food getFood();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
