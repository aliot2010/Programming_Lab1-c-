package breakfast;

import food.Food;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by aliot on 25.09.2016.
 */
public class Breakfast {
    ArrayList list;
    private static int SORTED_FLAG=1;
    private static int CONSUME_FLAG=2;
    private static String SORT_STRING_FLAG="-sort";
    private static String CONSUME_STRING_FLAG="-colories";
    private int flag=0;

    public Breakfast(ArrayList list){//сортировка в зависимости от от параметра -parametr
       this.list = list;
        if(list.get(list.size()-1)==SORT_STRING_FLAG){
            flag=SORTED_FLAG;
            list.remove(list.size()-1);
            sortArray();
        }else if (list.get(list.size()-1)==CONSUME_STRING_FLAG){
            flag=CONSUME_FLAG;
            list.remove(list.size()-1);
        }
    }

    private void sortArray() {
//        Collections.sort(list, new Comparator() {//сортировка используя переопределение анонимного
//            // класса Comparator
//            @Override
//            public int compare(Object o1, Object o2) {
//                 if(((Food) o1).getDescription().length()>
//                        (((Food) o2).getDescription().length())){
//                     return 1;
//                 } else if(((Food) o1).getDescription().length()<
//                         (((Food) o2).getDescription().length())){
//                     return -1;
//                 }else return 0;
//            }
//        });
        Collections.sort(list, (o1, o2) -> {//Лямбда)
            if(((Food) o1).getDescription().length()>
                        (((Food) o2).getDescription().length())){
                     return 1;
                 } else if(((Food) o1).getDescription().length()<
                         (((Food) o2).getDescription().length())){
                     return -1;
                 }else return 0;
        });

    }

    @Override
    public String toString() {//переопределение метода, выводит в зависимости от параметра -parametr
        StringBuffer stringBuffer=null;
        if (flag==0 || flag==SORTED_FLAG) {
             stringBuffer = new StringBuffer("Your breakfast, ser:\n");
            for (Object i : list) {
                stringBuffer.append(((Food) i).getDescription() + "\n");

            }
        }else{
             stringBuffer = new StringBuffer("Colories in your breakfast = " +
                                                    String.valueOf(this.getColories()));

        }
        return stringBuffer.toString();
    }

    public  double getColories(){
        double sum=0;
        for (Object i : list){
            sum+=((Food)i).colories();
        }
        return sum;
    }

    public int getFlag() {
        return flag;
    }

    public int numberOfProducts(Food food){
        int sum=0;
        for (Object i:list){
            if(i.equals(food)){
                sum++;
            }
        }
        return sum;
    }
}
