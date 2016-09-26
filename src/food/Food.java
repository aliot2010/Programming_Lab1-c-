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
public abstract class Food implements Nutritions {
    String description="Неизвестная еда";//хранение названия

    public String getDescription(){
        return description;
    }

}
