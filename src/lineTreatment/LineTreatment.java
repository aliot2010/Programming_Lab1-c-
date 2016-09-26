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

        List arrayList = new ArrayList(0);
        List arrayList2;
        for (String st : list) {

            String[] arr = st.split("/"); //Каждая строка делится  на на массивы строк "/"- разделитель

            arrayList2 = new ArrayList(0);
            for (String word : arr) {
                arrayList2.add(word);//создаеи подмассив массива

            }
            arrayList.add(arrayList2);//записываем подмассив в массив

            //получается массив вида [[Sandwich, Meat, Cheese], [Sanwich, Meat, Tomato],
            // [Sanwich,Cheese], "-sort"(опционально)]
        }


        return createArrayOfObj((ArrayList<Object>) arrayList);
    }

    private static ArrayList<Object> createArrayOfObj(ArrayList<Object> arrayList) {//Функция для создания массмва Объектов из строк продуктоа
        //Через Reflection API
        ArrayList<Object> list = new ArrayList<>(0);//Создаем массив элементов размера 0
        for (Object obj : arrayList) {//последовательно достаем из него объекты
            Food food = null;
            boolean flag=true;
            for (int i = 0; i < ((ArrayList) obj).size(); i++) {
                if(((ArrayList) obj).get(i).equals("-sort")){//если элемент массива есть строка "-sort"
                                                            //записываем ее в конец конечного массива и
                                                            // закнчиваем функцию возвращая этот массив
                    list.add("-sort");
                    return list;
                }else  if(((ArrayList) obj).get(i).equals("-colories")){//аналогично
                        list.add("-colories");
                        return list;
                }
                if (i == 0) {
                    Class c = null;
                    try {
                        c = Class.forName("food."+(String) ((ArrayList) obj).get(i));//для первого продукта подмассива(sandwich)
                                                                                    //находи класс по полному имени(имя package+имя класса)

                        Object object = c.newInstance(); //создаем объект данного класса
                        food = (Food) object;//кастим и присваеваем ссылку переменной food
                    } catch (Exception e) {//обработка ошибки
                        System.out.println("Продукт "+ (String) ((ArrayList) obj).get(i)+
                                                " не может быть включен в завтрак");
                            food=null;
                        flag=false;
//                        list.add(food);
                       // list.remove(list.size()-1);

                    }

                } else {
                    Class c = null;
                    try {
                        c = Class.forName("food."+(String) ((ArrayList) obj).get(i));//для его декораторов
                        Constructor c1 = c.getConstructor(Food.class);//находим конструктор с параметрами
                        food = (Food) c1.newInstance(food);//создаем класс, используя этот конструктор
                    } catch (Exception e ) {
                       // e.printStackTrace();
                        System.out.println("Продукт "+ (String) ((ArrayList) obj).get(i)+
                                " не может быть включен в завтрак");
                           food=null;
                        flag=false;
//                        if(food!=null) {
//                            list.add(food);
                        //list.remove(list.size()-1);

//                        }


                    }
                }
            }
            if(flag==true) {
                list.add(food);//добавляем декорированный класс в массив
            }
        }
        return  list;
    }
}
