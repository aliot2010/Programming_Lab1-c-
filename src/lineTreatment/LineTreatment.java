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
 * Нужно еще улучшить
 */
public final class LineTreatment {

    public static ArrayList<Object> treat(String[] list) {

        List arrayList = new ArrayList(0);
        List arrayList2;
        for (String st : list) {

            String[] arr = st.split("/");

            arrayList2 = new ArrayList(0);
            for (String word : arr) {
                arrayList2.add(word);
                System.out.println(word);
            }
            arrayList.add(arrayList2);

        }


        return createArrayOfObj((ArrayList<Object>) arrayList);//массив массивов
    }

    private static ArrayList<Object> createArrayOfObj(ArrayList<Object> arrayList) {
        ArrayList<Object> list = new ArrayList<>(arrayList.size());
        for (Object obj : arrayList) {
            Food food = null;
            for (int i = 0; i < ((ArrayList) obj).size(); i++) {

                if (i == 0) {
                    Class c = null;
                    try {
                        c = Class.forName("food."+(String) ((ArrayList) obj).get(i));
                        Object object = c.newInstance();
                        food = (Food) object;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                } else {
                    Class c = null;
                    try {
                        c = Class.forName("food."+(String) ((ArrayList) obj).get(i));
                        Constructor c1 = c.getConstructor(Food.class);
                        food = (Food) c1.newInstance(food);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            list.add(food);
        }
        return  list;
    }
}
