package lineTreatment;

import food.Food;
import food.FoodDecorator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by aliot on 24.09.2016.
 * Класс для обработки входных данных
 */
public final class LineTreatment {
    private static Boolean flag = false;

    public static ArrayList<Object> treat(String[] list) {

        List listOfFullProductsNames = new ArrayList(0);
        List innerList;
        for (String st : list) {

            String[] arr = st.split("/"); //Каждая строка делится  на на массивы строк "/"- разделитель

            innerList = new ArrayList(0);
            for (String word : arr) {
                innerList.add(word);//создаеи подмассив массива

            }
            sort(innerList);
            listOfFullProductsNames.add(innerList);//записываем подмассив в массив

            //получается массив вида [[Sandwich, Meat, Cheese], [Sanwich, Meat, Tomato],
            // [Sanwich,Cheese], "-sort"(опционально)]
        }


        return createArrayOfObj((ArrayList<Object>) listOfFullProductsNames);
    }

    private static void sort(List innerList) {
        boolean flag = true;
        //List list = innerList.subList(1, innerList.size());
        while (flag == true) {
            flag = false;
            for (int i = 1; i < innerList.size() -1; i++) {
                if (((String) innerList.get(i)).compareTo(((String) innerList.get(i + 1))) > 0) {
                    Collections.swap(innerList, i, i + 1);
                    flag = true;
                }
            }
        }

    }

    private static ArrayList<Object> createArrayOfObj(ArrayList<Object> listOfFoodNames) {//Функция для создания массмва Объектов из строк продуктоа
        //Через Reflection API
        ArrayList<Object> returnubleList = new ArrayList<>(0);//Создаем массив элементов размера 0
        for (Object obj : listOfFoodNames) {//последовательно достаем из принимаемого массива объекты
            Food food = null;
            flag = true;


            for (int i = 0; i < ((ArrayList) obj).size(); i++) {

                if (((ArrayList) obj).get(i).equals("-sort")) {
                    returnubleList.add("-sort");
                    flag=false;
                    continue;

                } else if (((ArrayList) obj).get(i).equals("-colories")) {//аналогично
                    returnubleList.add("-colories");
                    flag=false;
                    continue;
                }
                if (i == 0) {
                    food = getFood(food, (String) ((ArrayList) obj).get(i));
                } else {
                    food = getFoodDecorator(food, (String) ((ArrayList) obj).get(i));
                }
            }
            if (flag == true) {
                returnubleList.add(food);//добавляем декорированный класс в массив
            }
        }
        return returnubleList;
    }

    private static Food getFood(Food food, String nameOfFood) {
        Class clazz = null;

        try {
            clazz = Class.forName("food." + nameOfFood);//для первого продукта подмассива(sandwich)
            //находи класс по полному имени(имя package+имя класса)

            Object object = clazz.newInstance(); //создаем объект данного класса
            food = (Food) object;//кастим и присваеваем ссылку переменной food
        } catch (Exception e) {//обработка ошибки
            System.out.println("Продукт " + nameOfFood +
                    " не может быть включен в завтрак");
            food = null;
            flag = false;
        }
        return food;
    }

    private static Food getFoodDecorator(Food food, String nameOfFood) {
        Class clazz = null;
        try {
            clazz = Class.forName("food." + nameOfFood);//для его декораторов
            Constructor c1 = clazz.getConstructor(Food.class);//находим конструктор с параметрами
            food = (Food) c1.newInstance(food);//создаем класс, используя этот конструктор
        } catch (Exception e) {
            System.out.println("Продукт " + nameOfFood +
                    " не может быть включен в завтрак");
            food = null;
            flag = false;

        }
        return food;
    }
}



