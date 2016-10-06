package food;

/**
 * Created by aliot on 24.09.2016.
 * Реализовать паттерны Декоратор, Фабрика
 * Абстрактный класс
 *
 *
 *
 *
 */
public abstract class Food implements Nutritions, Consumable {
    String description="Неизвестная еда";//хранение названия
    double colories = 300.;
    public String getDescription(){
        return description;
    }

    @Override
    public void consume() {
        System.out.println(description + " ate ");
    }
}
