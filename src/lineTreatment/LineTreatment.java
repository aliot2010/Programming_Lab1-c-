package lineTreatment;

import food.Food;
import food.FoodDecorator;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliot on 24.09.2016.
 * Класс для обработки входных данных
 *
 */
public final class LineTreatment {

    public static ArrayList<Object> treat(String[] list) {

        List listOfFullProductsNames = new ArrayList(0);
        List innerList;
        for (String st : list) {

            String[] arr = st.split("/"); //Каждая строка делится  на на массивы строк "/"- разделитель

            innerList = new ArrayList(0);
            for (String word : arr) {
                innerList.add(word);//создаеи подмассив массива

            }
            listOfFullProductsNames.add(innerList);//записываем подмассив в массив

            //получается массив вида [[Sandwich, Meat, Cheese], [Sanwich, Meat, Tomato],
            // [Sanwich,Cheese], "-sort"(опционально)]
        }


        return createArrayOfObj((ArrayList<Object>) listOfFullProductsNames);
    }

    private static ArrayList<Object> createArrayOfObj(ArrayList<Object> listOfFoodNames) {//Функция для создания массмва Объектов из строк продуктоа
        //Через Reflection API
        ArrayList<Object> returnubleList = new ArrayList<>(0);//Создаем массив элементов размера 0
        for (Object obj : listOfFoodNames) {//последовательно достаем из принимаемого массива объекты
            Food food = null;
            boolean flag=true;
            for (int i = 0; i < ((ArrayList) obj).size(); i++) {
                if(((ArrayList) obj).get(i).equals("-sort")){//если элемент массива есть строка "-sort"
                                                            //записываем ее в конец конечного массива и
                                                            // закнчиваем функцию возвращая этот массив
                    returnubleList.add("-sort");
                    return returnubleList;
                }else  if(((ArrayList) obj).get(i).equals("-colories")){//аналогично
                        returnubleList.add("-colories");
                        return returnubleList;
                }
                if (i == 0) {
                    Class clazz = null;
                    try {
                        clazz = Class.forName("food."+(String) ((ArrayList) obj).get(i));//для первого продукта подмассива(sandwich)
                                                                                    //находи класс по полному имени(имя package+имя класса)

                        Object object = clazz.newInstance(); //создаем объект данного класса
                        food = (Food) object;//кастим и присваеваем ссылку переменной food
                    } catch (Exception e) {//обработка ошибки
                        System.out.println("Продукт "+ (String) ((ArrayList) obj).get(i)+
                                                " не может быть включен в завтрак");
                            food=null;
                        flag=false;
                    }

                } else {
                    Class clazz = null;
                    try {
                        clazz = Class.forName("food."+(String) ((ArrayList) obj).get(i));//для его декораторов
                        Constructor c1 = clazz.getConstructor(Food.class);//находим конструктор с параметрами
                        food = (Food) c1.newInstance(food);//создаем класс, используя этот конструктор
                    } catch (Exception e ) {
                        System.out.println("Продукт "+ (String) ((ArrayList) obj).get(i)+
                                " не может быть включен в завтрак");
                           food=null;
                        flag=false;

                    }
                }
            }
            if(flag==true) {
                returnubleList.add(food);//добавляем декорированный класс в массив
            }
        }
        return  returnubleList;
    }
}



